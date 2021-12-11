import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FilterCollections {
    private static final Logger logger = LoggerFactory.getLogger(FilterCollections.class);

    public static void filterArray() {
        ArrayList<String> names = new ArrayList<>();
        names.add("Mariami");
        names.add("Otari");
        names.add("Nikolozi");
        names.add("Ana");

        List<String> filteredNames = names
                .stream()
                .filter(n -> {
                    try {
                        return n.length() > 5;
                    }catch (Exception ex) {
                        logger.error("Unexpected error occurred: ", ex);
                    }
                    return false;
                })
                .collect(Collectors.toList());

        System.out.println("Filtered names ArrayList: ");
        filteredNames.forEach(
                (element) -> {
                    System.out.println(element);
                }

        );
    }


    public static void filterMap() {
        Map<String, Integer> animals = new HashMap<>();
        animals.put("Lion", 200);
        animals.put("Rabbit", 8);
        animals.put("Mouse", 2);
        animals.put("Dog", 30);

        Map<String, Integer> filteredAnimals = new HashMap<>();
        try {
            filteredAnimals = animals
                    .entrySet()
                    .stream()
                    .filter(FilterCollections::hasValidWeight)
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        }catch (Exception ex) {
            logger.error("Unexpected error occurred: ", ex);
        }

        System.out.println("\nFiltered animals HashMap: ");

        filteredAnimals.forEach(
                (specie, weight) -> {
                    System.out.println(specie);
                }
        );

    }

    public static boolean hasValidWeight(Map.Entry<String, Integer> entry) {
        return entry.getValue() > 20;
    }



}
