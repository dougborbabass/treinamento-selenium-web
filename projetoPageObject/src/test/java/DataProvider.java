

public class DataProvider {


    @org.testng.annotations.DataProvider(name = "provider")
    public Object[][] getEmployeeData() {
        return new Object[][]{
                {"Douglas", "Borba", "Mestrado", "Nivelamento"},
                {"Douglas", "Borba", "Mestrado", "Nivelamento"}};
    }
}
