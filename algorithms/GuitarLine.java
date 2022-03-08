import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 计算吉他琴弦在每品上的音调
 * 是否会在某一行上，音调完全一样？
 * 为什么会循环而不，出现同样的音调在同一品上呢？每根弦的音程规则一样，但是定音不一样。
 *
 * 1. 每 12 品为一个循环; 2. 音程关系占 12 品，也就是一个八度；3. 循环内的每根弦，包含一个完整八度。4. 第 12 品都是升音。
 *
 * @author brian.zhou
 * @date 3/4/22
 */
public class GuitarLine {

    private static final int BLANK = 9;
    private static final int[] INTERVAL_CONFIG = {1, BLANK, 2, BLANK, 3, 4, BLANK, 5, BLANK, 6, BLANK, 7};
    private static final Map<Integer, Integer> TONE_INDEX = new HashMap<Integer, Integer>();
    private static final List<LinkedList<Integer>> GUITAR_LINES = new LinkedList<>();

    static {
        TONE_INDEX.put(1, 0);
        TONE_INDEX.put(2, 2);
        TONE_INDEX.put(3, 4);
        TONE_INDEX.put(4, 5);
        TONE_INDEX.put(5, 7);
        TONE_INDEX.put(6, 9);
        TONE_INDEX.put(7, 11);

        LinkedList<Integer> firstLine = new LinkedList<>();
        firstLine.add(3);
        GUITAR_LINES.add(firstLine);
        LinkedList<Integer> secondLine = new LinkedList<>();
        secondLine.add(6);
        GUITAR_LINES.add(secondLine);
        LinkedList<Integer> thirdLine = new LinkedList<>();
        thirdLine.add(2);
        GUITAR_LINES.add(thirdLine);
        LinkedList<Integer> fourthLine = new LinkedList<>();
        fourthLine.add(5);
        GUITAR_LINES.add(fourthLine);
        LinkedList<Integer> fifthLine = new LinkedList<>();
        fifthLine.add(7);
        GUITAR_LINES.add(fifthLine);
        LinkedList<Integer> sixthLine = new LinkedList<>();
        sixthLine.add(3);
        GUITAR_LINES.add(sixthLine);
    }

    public static void main(String[] args) {
        boolean found = false;
        do {
            Integer align = 0;
            for (int i = 0; i < GUITAR_LINES.size(); i++) {
                LinkedList<Integer> line = GUITAR_LINES.get(i);
                Integer fret = line.getLast();
                System.out.print((fret == 9 ? " " : fret) + " |");
                int index = fret == BLANK
                        ? (TONE_INDEX.get(line.get(line.size() - 2)) + 2)
                        : TONE_INDEX.get(fret) + 1;
                line.addLast(INTERVAL_CONFIG[index % INTERVAL_CONFIG.length]);
                align += fret == BLANK ? 0 : fret;
                found = align / fret == i;
            }
            System.out.println();
        } while (!found);
    }
}
