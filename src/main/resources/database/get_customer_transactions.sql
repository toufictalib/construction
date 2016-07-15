DELIMITER $$

USE `construction`$$

DROP PROCEDURE IF EXISTS `get_customer_transactions`$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `get_customer_transactions`(IN p_customer_id BIGINT,IN p_contract_id BIGINT)
BEGIN
DECLARE vtemp VARCHAR(50) DEFAULT 0;
  
    SELECT 
  t.`id`,
  t.`description`,
  CONCAT(t.value," $"),
 IF (t.`payment_movement` = 0 , CONCAT(t.value," $") , "") AS "Purchase" ,
 IF (t.`payment_movement` = 1 , CONCAT(t.value," $") , "") AS "Payment" ,
   t.`payment_cause`,
  t.`payment_movement`,
  p.`name`,
  p.`last_name`,
  p.`phone1`,
  p.`email`,
  ti.`name` 
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