package com.qaisarabbas.notification_service.repositories;

import com.qaisarabbas.notification_service.domain.EmailNotification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailNotificationRepository extends JpaRepository<EmailNotification, Long> {
}
