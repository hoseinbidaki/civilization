package Models.Asset.cityAsset;

public class CityProduct {
    private double currentProduct;
    public void add(double number) {
        currentProduct += number;
    }
    public double getCurrentProduct() {
        return currentProduct;
    }

    public void setCurrentProduct(double currentProduct) {
        this.currentProduct = currentProduct;
    }

}
