package hackerrank;

import java.util.HashMap;
import java.util.stream.Collectors;

public class FurnitureOrder implements FurnitureOrderInterface {
    /**
     * TODO: Create a map of Furniture items to order quantities
     */

    /**
     * Initialize a new mapping of Furniture types to order quantities.
     */
	private final HashMap<Furniture,Integer> furnituresMap;
    FurnitureOrder() {
        // TODO: Complete the constructor
    	furnituresMap = new HashMap<Furniture,Integer>();
    }

    public void addToOrder(final Furniture type, final int furnitureCount) {
        Integer countOfOrder = 0;
        if(furnituresMap.containsKey(type)){
        	countOfOrder = furnituresMap.get(type);
        }
        furnituresMap.put(type, countOfOrder + furnitureCount);
    }

    public HashMap<Furniture, Integer> getOrderedFurniture() {
    	return new HashMap<Furniture,Integer>(furnituresMap);
    }

    public float getTotalOrderCost() {
        if(!furnituresMap.isEmpty()) {
        	return furnituresMap.entrySet().stream().map(e-> e.getKey().cost() * e.getValue())
        			.collect(Collectors.toList())
        			.stream().reduce(Float::sum).get();
        }
        return 0.0f;
    }

    public int getTypeCount(Furniture type) {
       if(furnituresMap.containsKey(type)) {
    	   return furnituresMap.get(type);
       }
       return 0;
    }

    public float getTypeCost(Furniture type) {
       if (furnituresMap.containsKey(type)) {
    	   return furnituresMap.get(type) * type.cost();
       }
       return 0.0f;
    }

    public int getTotalOrderQuantity() {
        if(!furnituresMap.isEmpty()) {
        	return furnituresMap.values().stream().reduce(Integer::sum).get();
        }
        return 0;
    }
}