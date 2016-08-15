DELIMITER $$

USE `construction`$$

DROP PROCEDURE IF EXISTS `get_supplier_transactions`$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `get_supplier_transactions`(IN p_supplier_id BIGINT,IN p_project_id BIGINT,
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
	CAST(IF (t.`payment_movement` = 2 , CONCAT(t.value) , NULL) AS DECIMAL(10,2))AS "Purchase" ,
	CAST(IF (t.`payment_movement` = 4 , CONCAT(t.value) , NULL)AS DECIMAL(10,2)) AS "Payment" ,
	`getPaymentMovementValue`(t.`payment_movement`) as "Payment Movement",
	t.date_creation as "Creation Date"
	
FROM
  TRANSACTION t 
  LEFT JOIN `person` p 
    ON p.`id` = t.`reference_id` 
  LEFT JOIN title ti 
    ON ti.`id` = p.`title` 
    
WHERE t.`payer` = 0
AND t.`reference_id` =', p_supplier_id,
  /*Customer*/
  ' AND t.project = ',p_project_id,
  ' and t.`payment_movement` in (2,4)',v_where,'order by t.date_creation desc limit ',p_start_count,',',p_end_count)
	
  ;
    SET @s =v_where;
	PREPARE stmt FROM 	@s;
	EXECUTE stmt;
  
    END$$

DELIMITER ;