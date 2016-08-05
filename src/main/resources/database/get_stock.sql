SELECT 
  i.`id`,
  p.`name`,
 
  IF(t.payment_movement=1, i.`quantity`,NULL) AS "INITIAL STOCK",
  IF(t.payment_movement=1,NULL, i.`quantity`) AS "RECEIVED STOCK",
 i.`price`,
  i.`price` * i.`quantity` AS "Sub Total",
  IF(t.payment_movement=1,"INITIAL STOCK","RECEIVED STOCK") AS "Stock Movement",
  
   i.`transaction`
FROM
  item i 
  LEFT JOIN product p 
    ON p.`id` = i.`product` 
    LEFT JOIN `transaction` t ON t.id = i.transaction 
    
    WHERE 1=1 AND p.id =1 AND t.reference_id=3