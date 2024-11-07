import java.util.PriorityQueue;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Node class representing each character and its frequency in the Huffman Tree
class HuffmanNode {
    char character;
    int frequency;
    HuffmanNode left, right;

    public HuffmanNode(char character, int frequency) {
        this.character = character;
        this.frequency = frequency;
    }
}

public class HuffmanEncoding {

    // Build Huffman Tree and generate codes
    public static Map<Character, String> buildHuffmanTree(Map<Character, Integer> frequencies) {
        PriorityQueue<HuffmanNode> queue = new PriorityQueue<>((a, b) -> a.frequency - b.frequency);

        for (Map.Entry<Character, Integer> entry : frequencies.entrySet()) {
            queue.add(new HuffmanNode(entry.getKey(), entry.getValue()));
        }

        while (queue.size() > 1) {
            HuffmanNode left = queue.poll();
            HuffmanNode right = queue.poll();
            HuffmanNode parent = new HuffmanNode('\0', left.frequency + right.frequency);
            parent.left = left;
            parent.right = right;
            queue.add(parent);
        }

        Map<Character, String> huffmanCodes = new HashMap<>();
        generateCodes(queue.poll(), "", huffmanCodes);
        return huffmanCodes;
    }

    // Recursive function to generate codes for each character
    private static void generateCodes(HuffmanNode node, String code, Map<Character, String> huffmanCodes) {
        if (node == null) return;
        if (node.left == null && node.right == null) huffmanCodes.put(node.character, code);
        generateCodes(node.left, code + "0", huffmanCodes);
        generateCodes(node.right, code + "1", huffmanCodes);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text to encode: ");
        String text = scanner.nextLine();
        scanner.close();

        Map<Character, Integer> frequencies = new HashMap<>();
        for (char character : text.toCharArray()) {
            frequencies.put(character, frequencies.getOrDefault(character, 0) + 1);
        }

        Map<Character, String> huffmanCodes = buildHuffmanTree(frequencies);

        System.out.println("Huffman Codes: " + huffmanCodes);

        StringBuilder encodedText = new StringBuilder();
        for (char character : text.toCharArray()) {
            encodedText.append(huffmanCodes.get(character));
        }
        System.out.println("Encoded Text: " + encodedText);
    }
}
