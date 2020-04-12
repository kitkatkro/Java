import java.util.*;

public class StringCount {
    public static void main(String[] args) {
        String[] array = {"We", "all", "are", "living", "in", "a", "dream", "but", "life", "ain't", "what", "it",
                "seems", "Oh", "everything", "is", "a", "mess", "And", "all", "these", "sorrows", "I", "have", "seen",
                "They", "lead", "me", "to", "believe", "That", "everything", "is", "a", "mess"};

        Set<String> set = new HashSet<>(Arrays.asList(array));
        System.out.println("Список слов, из которых состоит текст:\n" + set);

        HashMap<String,Integer> map = new HashMap<>();
        for (int i=0; i < array.length; i++) {
            if (map.containsKey(array[i])) {
                map.put(array[i], map.get(array[i])+1);
            } else {
                map.put(array[i], 1);
            }
        }
        for (Map.Entry<String, Integer> pair : map.entrySet()) {
            System.out.println(pair.getKey() + " - " + pair.getValue());
        }

    }
}
