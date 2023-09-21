package ch13;

class TV {
    @Override
    public String toString() {
        return "TV";
    }
}

class Car {
    
}

class Product<K, M> {
	private K kind;
	private M model;

    K getKind() {
        return this.kind;
    }

    M getModel() {
        return this.model;
    }

    public void setKind(K kind) {
        this.kind = kind;
    }

    public void setModel(M model) {
        this.model = model;
    }
}

public class ProductTest {
    public static void main(String[] args) {
        Product<TV, String> product1 = new Product<>();

        product1.setKind(new TV());
        product1.setModel("스마트TV");

        System.out.println("제품 : " + product1.getKind().toString() + " " + product1.getModel());
    }
}
