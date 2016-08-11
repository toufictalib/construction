package database.functions;

public class Snippet
{
	DELIMITER $$
	
	USE `construction`$$
	
	DROP FUNCTION IF EXISTS `getPaymentMovementValue`$$
	
	CREATE DEFINER=`root`@`localhost` FUNCTION `getPaymentMovementValue`(payment_movement INT) RETURNS VARCHAR(25) CHARSET utf8
	BEGIN 
			
	DECLARE NAME_FOUND VARCHAR(25) DEFAULT "Down Payment";
	IF payment_movement=1
	THEN SET NAME_FOUND = "Payment Receipt";
	END IF;
	IF payment_movement=2
	THEN SET NAME_FOUND = "Purchase Invoice";
	END IF;
	IF payment_movement=3
	THEN SET NAME_FOUND = "Purchase Real Estate";
	END IF;
	IF payment_movement=4
	THEN SET NAME_FOUND = "Payment Invoice";
	END IF;
	IF payment_movement=5
	THEN SET NAME_FOUND = "Stock Init";
	END IF;
	IF payment_movement=6
	THEN SET NAME_FOUND = "Receiving Stock";
	END IF;
	RETURN NAME_FOUND;
	END$$
	
	DELIMITER ;
}

