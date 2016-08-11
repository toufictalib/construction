DELIMITER $$

USE `construction`$$

DROP PROCEDURE IF EXISTS `get_supplier_transactions`$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `get_supplier_transactions`(IN p_customer_id BIGINT,IN p_project_id BIGINT)
BEGIN
  
  SELECT 
	t.`id`,
	t.`description`,
	CAST(IF (t.`payment_movement` = 2 , CONCAT(t.value) , NULL) AS DECIMAL(10,2))AS "Purchase" ,
	CAST(IF (t.`payment_movement` = 4 , CONCAT(t.value) , NULL)AS DECIMAL(10,2)) AS "Payment" ,
	`getPaymentMovementValue`(t.`payment_movement`) AS "Payment Movement"
	
FROM
  TRANSACTION t 
  LEFT JOIN `person` p 
    ON p.`id` = t.`reference_id` 
  LEFT JOIN title ti 
    ON ti.`id` = p.`title` 
    
WHERE t.`payer` = 0
AND t.`reference_id` = p_customer_id
  /*Customer*/
  AND t.project = p_project_id
  AND t.`payment_movement` IN (2,4)
	
  ;
    
  
    END$$

DELIMITER ;