DELIMITER $$

USE `construction`$$

DROP PROCEDURE IF EXISTS `get_customer_transactions`$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `get_customer_transactions`(IN p_customer_id BIGINT,IN p_contract_id BIGINT)
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
	CAST(IF (t.`payment_movement` = 3 , t.value , NULL) AS DECIMAL(10,2)) AS "Purchase" ,
	CAST(IF (t.`payment_movement` = 0 OR t.`payment_movement` = 1 , t.value, NULL) AS DECIMAL(10,2)) AS "Payment" ,
	`getPaymentMovementValue`(t.`payment_movement`) AS "Payment Movement"
	
FROM
  TRANSACTION t 
  LEFT JOIN `person` p 
    ON p.`id` = t.`reference_id` 
  LEFT JOIN title ti 
    ON ti.`id` = p.`title` 
    
WHERE t.`payer` = 1
AND t.`reference_id` = p_customer_id
  /*Customer*/
  AND t.`contract` = p_contract_id
	
  ;
    
  
    END$$

DELIMITER ;