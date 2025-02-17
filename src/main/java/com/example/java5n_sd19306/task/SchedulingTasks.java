package com.example.java5n_sd19306.task;
import com.example.java5n_sd19306.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
//@Slf4j // Lombok log
@RequiredArgsConstructor
public class SchedulingTasks {

    private static final Logger log = LoggerFactory.getLogger(SchedulingTasks.class);
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:m:ss");

    private final ProductService productService;

    // 1.
    //@Scheduled(fixedRate = 2000)
    //public void scheduledTaskWithFixedRate() {
    //
    //    log.info("Fixed Rate Task :: Execution Time - {}", dateTimeFormatter.format(LocalDateTime.now()));
    //}

    // 2.
    //@Scheduled(fixedDelay = 2000)
    //public void scheduledTaskWithFixedDelay() {
    //
    //    log.info("Fixed Rate Task :: Execution Time - {}", dateTimeFormatter.format(LocalDateTime.now()));
    //}

    // 3.
    //@Scheduled(fixedRate = 2000, initialDelay = 5000)
    //public void scheduledTaskWithInitialDelay() {
    //
    //    log.info("Fixed Rate Task :: Execution Time - {}", dateTimeFormatter.format(LocalDateTime.now()));
    //}

    // 4. cron
    @Scheduled(cron = "*/10 * * * * *")
    public void scheduleTaskWithCronExpression() {

        log.info("Cron Task :: Execution Time - {}", dateTimeFormatter.format(LocalDateTime.now()));
        log.info("Products in DB - {}", productService.getAllProducts().size());
    }
}

