package Brand;

import java.util.ArrayList;
import java.util.Comparator;

public class BrandManager {

    static ArrayList<Brand> brands = new ArrayList<>();

    public static ArrayList<Brand> getBrands() {
        return brands;
    }

    public static void setBrands(ArrayList<Brand> brands) {
        BrandManager.brands = brands;
    }

    public Brand getBrands(int id) {
        return brands.get(id - 1);
    }

    public void addBrand(int id, String brandName) {
        Brand brand = new Brand(id, brandName);
        brands.add(brand);
    }


    public void deleteBrand(int id) {
        brands.remove(id - 1);
    }


    public void printBrand() {
        for (Brand brand : brands) {
            System.out.println(brand.getId() + "- " + brand.getBrandName());
        }
    }

    public void printBrandSortedName() {
        ArrayList<Brand> brandName = new ArrayList<Brand>(brands);

        Comparator<Brand> sorter = new Comparator<Brand>() {
            @Override
            public int compare(Brand o1, Brand o2) {
                return o1.getBrandName().compareTo(o2.getBrandName());
            }

        };
        brandName.sort(sorter);
        for (Brand brand : brandName) {
            System.out.println("- " + brand.getBrandName());
        }
    }


}
