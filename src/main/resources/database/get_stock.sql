DELIMITER $$

USE `construction`$$

DROP PROCEDURE IF EXISTS `get_stock`$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `get_stock`(
IN p_product_id BIGINT,
IN p_supplier_id BIGINT,
IN p_project_id BIGINT,
IN p_from_date VARCHAR(25)
,p_to_date VARCHAR(25)
,IN p_start_count INT,
IN p_end_count INT)
BEGIN
  DECLARE v_where VARCHAR(1000) DEFAULT "";
  DECLARE sql_query VARCHAR(2000) DEFAULT " ";
  
		
SET sql_query=
'SELECT 
  i.`id`,
  p.`name`,
 
  IF(t.payment_movement=1, i.`quantity`,NULL) AS "INITIAL STOCK",
  IF(t.payment_movement=1,NULL, i.`quantity`) AS "RECEIVED STOCK",
 i.`price`,
  i.`price` * i.`quantity` AS "Sub Total",
  IF(t.payment_movement=1,"INITIAL STOCK","RECEIVED STOCK") AS "Stock Movement",
  
   i.`transaction`,
   t.date_creation as "Creation Date"
FROM
  item i 
  LEFT JOIN product p 
    ON p.`id` = i.`product` 
    LEFT JOIN `transaction` t ON t.id = i.transaction 
    
    WHERE  t.`project` =';
    
    SET sql_query = CONCAT(sql_query,p_project_id);		
 
 IF(p_product_id <> -1) THEN
	SET v_where=CONCAT(v_where," and p.id =", p_product_id);
	END IF;
	
	IF(p_supplier_id <> -1) THEN
	SET v_where=CONCAT(v_where," and t.reference_id=", p_supplier_id);
	END IF;
	
	 
   IF (p_from_date <> -1) THEN
		SET v_where = CONCAT(v_where,' and t.date_creation >=',"'",p_from_date,"'");
	END IF;
	
	IF (p_to_date <> -1) THEN
		SET v_where = CONCAT(v_where,' and t.date_creation <=',"'",p_to_date,"'");
	END IF;
	
 SET sql_query = CONCAT(sql_query,v_where,' order by t.date_creation desc limit ',p_start_count,',',p_end_count);
    SET @s =sql_query;
	PREPARE stmt FROM 	@s;
	EXECUTE stmt;
    
   INSERT INTO queries(VALUE,date_creation) VALUES(sql_query,NOW());
    END$$

DELIMITER ;