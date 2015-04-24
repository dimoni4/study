package patterns.behavioral;

/**
 * Created by dvetrov on 24/04/15.
 */
public interface Iterator {
    public Object next();
    public boolean hasNext();
}

class ClientIterator {
    public static void main(String[] args) {
        ProductsRepository productsRepository = new ProductsRepository();
        Iterator productsIterator = productsRepository.getIterator();
        while(productsIterator.hasNext()) {
            System.out.println(productsIterator.next());
        }
    }
}

interface Container {
    public Iterator getIterator();
}

class ProductsRepository implements Container {

    private String[] products = {"orange", "apple"};

    @Override
    public Iterator getIterator() {
        return new ProductsIterator();
    }

    class ProductsIterator implements Iterator {
        int index;

        @Override
        public Object next() {
            if(this.hasNext()){
                return products[index++];
            }
            return null;
        }

        @Override
        public boolean hasNext() {
            if(index < products.length) {
                return true;
            }
            return false;
        }
    }
}