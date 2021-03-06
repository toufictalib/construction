DELIMITER $$

USE `construction`$$

DROP PROCEDURE IF EXISTS `get_project_expenses_incomes`$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `get_project_expenses_incomes`(IN p_project_id BIGINT,IN p_from_date VARCHAR(25),p_to_date VARCHAR(25),IN p_start_count INT,IN p_end_count INT)
BEGIN
  
  DECLARE v_where VARCHAR(2000) DEFAULT " ";
  IF (p_from_date <> -1) THEN
		SET v_where = CONCAT(v_where,' and t.date_creation >=',"'",p_from_date,"'");
	END IF;
	
	IF (p_to_date <> -1) THEN
		SET v_where = CONCAT(v_where,' and t.date_creation <=',"'",p_to_date,"'");
	END IF;
	
	
  SET v_where  = CONCAT('
  SELECT 
   t.`id` AS "Transaction #",
 ti.`name` AS "Title",
  p.`name`,
  p.`last_name` AS "Last Name",
  
   
  t.`description`,
  CAST(IF (
    t.`payer` = 1,
    CONCAT(t.value),
    NULL
  )AS DECIMAL(10,2))AS "Income",
 CAST(IF (
    t.`payer` = 0,
    CONCAT(t.value),
    NULL
  ) AS DECIMAL(10,2) ) AS  "Depenses" ,
  
  `getPaymentMovementValue` (t.`payment_movement`) AS "Payment Movement",
  t.date_creation as "Creation Date"
  
FROM
TRANSACTION t 
  LEFT JOIN `person` p 
    ON p.`id` = t.`reference_id` 
  LEFT JOIN title ti 
    ON ti.`id` = p.`title` 
  
    
WHERE t.project =',p_project_id,'    
 ',v_where,' order by t.date_creation desc limit ',p_start_count,',',p_end_count)
;
    
	
	SET @s =v_where;
	PREPARE stmt FROM @s;
	EXECUTE stmt;
	 INSERT INTO queries(VALUE,date_creation) VALUES(v_where,NOW());
	
	
    END$$

DELIMITER ;