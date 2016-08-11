package desktopadmin.model.accounting;


public class EnumType
{
	public enum PaymentType
	{
		CASH, CHECK, INNER_CHECK;

		public String toString( )
		{
			switch (this)
			{
				case CASH:

					return "Cash";

				case CHECK:
					return "Check";
				case INNER_CHECK:
					return "Inner Check";
				default:
					break;
			}
			return "Unknow";
		}
	}

	public enum Payer
	{
		SUPPLIER, CUSTOMER;
	}
	

	public enum TransactionType
	{
		PAYMENT_DOWN,
		PAYMENT_RECEIPT,
		PURCHASE_INVOICE,
		PURCHASE_REAL_ESTATE,
		PAYMENT_INVOICE,
		
		
		STOCK_INIT,
		STOCK_RECEIVED;
	}

	public enum Currency
	{
		LBP, DOLLAR;

		public String toString( )
		{
			switch (this)
			{
				case LBP:

					return "LBP";

				case DOLLAR:
					return "$";
				default:
					break;
			}

			return "Unknow";

		};
	}
	
	public enum Direction
	{
		RIGHT,LEFT,CENTER;
	}
	
	public enum RealEstateType
	{
		FLAT,STORE,WAREHOUSE;
		
		public String toDiscriminator()
		{
			switch (this)
			{
				case FLAT:
					return "flat";
				case STORE:
					return "store";
				case WAREHOUSE:
					return "warehouse";

				default:
					break;
			}
			
			throw new RuntimeException("No Discriminator has already assigned to "+this);
		}
	}
	
	public enum ExtraRowType
	{
		NONE,SUM,AVERAGE,CURRENCY;
	}
	
}
