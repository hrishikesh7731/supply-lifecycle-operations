package com.supply_chain_easy.supply_lifecycle_operations.services;

import com.supply_chain_easy.supply_chain_base_operations.constants.SystemConstant;
import com.supply_chain_easy.supply_chain_base_operations.enums.NotificationPriority;
import com.supply_chain_easy.supply_chain_base_operations.enums.NotificationStatus;
import com.supply_chain_easy.supply_chain_base_operations.models.*;
import com.supply_chain_easy.supply_chain_base_operations.repositories.NotificationContextRepository;
import com.supply_chain_easy.supply_chain_base_operations.repositories.NotificationTemplateRepository;
import com.supply_chain_easy.supply_chain_base_operations.services.NotificationService;
import com.supply_chain_easy.supply_chain_base_operations.utilites.SystemUtility;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.time.Year;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutorService;

@Service
public class SupplierNotificationService {

    private final NotificationTemplateRepository notificationTemplateRepository;
    private final NotificationContextRepository notificationContextRepository;
    private final NotificationService notificationService;
    private final ExecutorService executorService;

    public SupplierNotificationService(
            NotificationTemplateRepository notificationTemplateRepository,
            NotificationContextRepository notificationContextRepository,
            NotificationService notificationService,
            ExecutorService executorService) {

        this.notificationTemplateRepository = notificationTemplateRepository;
        this.notificationContextRepository = notificationContextRepository;
        this.notificationService = notificationService;
        this.executorService = executorService;
    }

    public void sendSupplierWelcomeNotification(
            SupplierCompany supplierCompany, Employee admin) {

        NotificationTemplate template = notificationTemplateRepository
                .findById(SystemConstant.COMPANY_REGISTRATION_TEMPLATE_ID)
                .orElseThrow(() -> new RuntimeException(
                        "Supplier registration notification template not found"));

        NotificationContext context = createNotificationContext(supplierCompany, admin);

        Notification notification = Notification.builder()
                .notificationContext(context)
                .notificationId(SystemUtility.generateId("NOTIFICATION"))
                .notificationTemplate(template)
                .notificationPriority(NotificationPriority.URGENT)
                .notificationStatus(NotificationStatus.DRAFT)
                .isEmail(true)
                .isWhatsApp(false)
                .isSMS(false)
                .bccUsers(new ArrayList<>())
                .ccUsers(new ArrayList<>())
                .toUsers(List.of(admin))
                .createdAt(LocalDateTime.now())
                .createdBy("system")
                .updatedAt(LocalDateTime.now())
                .updatedBy("system")
                .build();

        executorService.submit(()->{notificationService.sendNotification(notification);});
    }

    private NotificationContext createNotificationContext(
            SupplierCompany supplierCompany, Employee admin) {

        HashMap<String, String> emailMap = new HashMap<>();

        emailMap.put("mainUserName", admin.getFirstName());
        emailMap.put("companyName", supplierCompany.getDisplayName());
        emailMap.put("mainUserEmail", admin.getEmail());
        emailMap.put("temporaryPassword", admin.getPassword());
        emailMap.put("applicationUrl", "https://google.com");
        emailMap.put("currentYear", String.valueOf(Year.now().getValue()));

        HashMap<String, String> subjectLineMap = new HashMap<>();
        subjectLineMap.put("companyName", supplierCompany.getDisplayName());

        NotificationContext context = new NotificationContext();

        context.setContextId(SystemUtility.generateId("NotificationContext"));
        context.setEmailMap(emailMap);
        context.setSubjectLineMap(subjectLineMap);
        context.setSmsMap(new HashMap<>());
        context.setWhatsAppMap(new HashMap<>());
        context.setCreatedAt(LocalDateTime.now());
        context.setUpdatedAt(LocalDateTime.now());
        context.setCreatedBy("system");
        context.setUpdatedBy("system");

        return notificationContextRepository.save(context);
    }
}