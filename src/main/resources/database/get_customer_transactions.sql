DELIMITER $$

USE `construction`$$

DROP PROCEDURE IF EXISTS `get_customer_transactions`$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `get_customer_transactions`(
IN p_customer_id BIGINT,
IN p_contract_id BIGINT,
IN p_from_date VARCHAR(25)
,p_to_date VARCHAR(25)
,IN p_start_count INT,
IN p_end_count INT)
BEGIN
  
  DECLARE v_where VARCHAR(2000) DEFAULT " ";
  
  IF (p_from_date <> -1) THEN
		SET v_where = CONCAT(v_where,' and t.date_creation >=',"'",p_from_date,"'");
	END IF;
	
	IF (p_to_date <> -1) THEN
		SET v_where = CONCAT(v_where,' and t.date_creation <=',"'",p_to_date,"'");
	END IF;
	
	
SET v_where = CONCAT('	
  SELECT 
 	t.`id`,
	t.`description`,
	CAST(IF (t.`payment_movement` = 3 , t.value , null) AS DECIMAL(10,2)) AS "Purchase" ,
	cast(IF (t.`payment_movement` = 0 OR t.`payment_movement` = 1 , t.value, null) AS DECIMAL(10,2)) AS "Payment" ,
	`getPaymentMovementValue`(t.`payment_movement`) as "Payment Movement",
	t.date_creation as "Creation Date"
	
FROM
  TRANSACTION t 
  LEFT JOIN `person` p 
    ON p.`id` = t.`reference_id` 
  LEFT JOIN title ti 
    ON ti.`id` = p.`title` 
    
WHERE t.`payer` = 1
AND t.`reference_id` =', p_customer_id,
  /*Customer*/
  ' and t.`contract`=' , p_contract_id,v_where,'order by t.date_creation desc limit ',p_start_count,',',p_end_count)
	
  ;
    SET @s =v_where;
	PREPARE stmt FROM 	@s;
	EXECUTE stmt;
  
    END$$

DELIMITER ;