package short52;

public class EastAsiaCountries extends Country{
    private String countryTerrain;

    public EastAsiaCountries(String countryCode, String countryName, float totalArea, String countryTerrain) {
        super(countryCode, countryName, totalArea); // Call to Country class constructor
        this.countryTerrain = countryTerrain;
    }
    
    public EastAsiaCountries() {
        super();
    }
    
    public String getCountryTerrain() {
        return countryTerrain;
    }

    public void setCountryTerrain(String countryTerrain) {
        this.countryTerrain = countryTerrain;
    }
    
    @Override
    public void display() {
        super.display();
        System.out.printf(" %s\n", countryTerrain);
    }

    public static void printHeader() {
        System.out.println("ID         Name            Total Area     Terrain");
    }
}
