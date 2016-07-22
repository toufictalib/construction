DELIMITER $$

USE `construction`$$

DROP PROCEDURE IF EXISTS `get_supplier_transactions`$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `get_supplier_transactions`(IN p_customer_id BIGINT,IN p_project_id BIGINT)
BEGIN
  
  SELECT 
  /*p.`name`,
	p.`last_name` ,
	p.`phone1`,
	p.`email`,
	ti.`name`,	
	*/
	t.`id`,
	t.`description`,
	IF (t.`payment_movement` = 0 , CONCAT(t.value," $") , "") AS "Purchase" ,
	IF (t.`payment_movement` = 1 , CONCAT(t.value," $") , "") AS "Payment" ,
	tc.`name` AS "Payment Cause",
	`getPaymentMovementValue`(t.`payment_movement`) AS "Payment Movement"
	
FROM
  TRANSACTION t 
  LEFT JOIN `person` p 
    ON p.`id` = t.`reference_id` 
  LEFT JOIN title ti 
    ON ti.`id` = p.`title` 
    LEFT JOIN `transaction_cause` tc ON t.`payment_cause` = tc.id
WHERE t.`payer` = 0
AND t.`reference_id` = p_customer_id
  /*Customer*/
  AND t.project = p_project_id
	
  ;
    
  
    END$$

DELIMITER ;