// Fig. 10.12: Invoice.java
// Invoice class that implements Payable.

public class Invoice implements Payable {
    private final String partNumber;
    private final String partDescription;
    private final int quantity;
    private final double pricePerItem;

    // Create constructor
    public Invoice(String partNumber, String partDescription, int quantity, double pricePerItem) {
    	if (quantity < 0) {
    		throw new IllegalArgumentException("Quantity must be >= 0");
    	}
    	
    	if (pricePerItem < 0.0) {
    		throw new IllegalArgumentException("Price per item must be >= 0");
    	}
    	
    	this.quantity = quantity;
    	this.partNumber = partNumber;
    	this.partDescription = partDescription;
    	this.pricePerItem = pricePerItem;
    }
    
    // return partNumber
	public String getPartNumber() {
		return partNumber;
	}
	// return Part Description
	public String getPartDescription() {
		return partDescription;
	}
	// return Quantity
	public int getQuantity() {
		return quantity;
	}
	// return pricePerItem 
	public double getPricePerItem() {
		return pricePerItem;
	}
	
	// return all variables
	@Override
	public String toString() {
		return String.format("%s: %n%s: %s (%s) %n%s: %d %n%s: $%,.2f", "invoice", "part number", getPartNumber(), getPartDescription(), "quantity", getQuantity(), "price per item", getPricePerItem());
	}
	
	// return Payment Amount for Invoice
	@Override
	public double getPaymentAmount() {
		return getQuantity() * getPricePerItem();
	}
}