public class SmartWatch extends Cellphone {
    private boolean hasEsim; 
    /* 
        hasEsim is an abbreviation for "has Embedded Subscriber Identity."
        has: Indicates a boolean property (true/false) that denotes possession or capability.
        eSIM: Stands for Embedded Subscriber Identity. 
        This is a digital SIM that allows a mobile device 
        (like a smartwatch or phone) to connect to a cellular network 
        without needing a physical SIM card.
    */

    // Constructor for SmartWatch
    // It must call the superclass constructor using 'super()'
    SmartWatch(String brand, String model, double price, boolean hasEsim) {
        // Call the Cellphone constructor to initialize inherited fields
        super(brand, model, price);
        this.hasEsim = hasEsim;
    }

    // New method specific to SmartWatch
    public void trackActivity() {
        System.out.println(getModel() + " is tracking heart rate and steps.");
    }

    // Getter for the new field
    public boolean isHasEsim() {
        return hasEsim;
    }

    // Override the toString() method to include the new field
    @Override
    public String toString() {
        // We use the superclass's toString and append the new field
        return super.toString().replace("Cellphone{", "SmartWatch{")
               + " -> {hasEsim=" + hasEsim + '}';
    }
}
