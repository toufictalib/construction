DELIMITER $$

USE `construction`$$

DROP PROCEDURE IF EXISTS `get_project_expenses_incomes`$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `get_project_expenses_incomes`(IN p_project_id BIGINT,IN p_start_date DATE,p_end_date DATE,IN p_start_count INT,IN p_end_count INT)
BEGIN
  
  SELECT 
 ti.`name` AS "Title",
  p.`name`,
  p.`last_name` AS "Last Name",
  p.`phone1`,
  p.`email`,
 
  t.`id` AS "Transaction #",
  t.`description`,
  IF (
    t.`payment_movement` = 0,
    CONCAT(t.value, " $"),
    ""
  ) AS "Purchase",
  IF (
    t.`payment_movement` = 1,
    CONCAT(t.value, " $"),
    ""
  ) AS "Payment",
  tc.`name` AS "Payment Cause",
  `getPaymentMovementValue` (t.`payment_movement`) AS "Payment Movement" 
FROM
  TRANSACTION t 
  LEFT JOIN `person` p 
    ON p.`id` = t.`reference_id` 
  LEFT JOIN title ti 
    ON ti.`id` = p.`title` 
  LEFT JOIN `transaction_cause` tc 
    ON t.`payment_cause` = tc.id 
    AND t.project = p_project_id 
UNION
SELECT 
   "","","","","","","",SUM(Purchase),SUM(Payment),"","";
	
    END$$

DELIMITER ;