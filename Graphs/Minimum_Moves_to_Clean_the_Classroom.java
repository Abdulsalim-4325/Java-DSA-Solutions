/*
Problem: Minimum Moves to Clean the Classroom

A student starts at 'S' with a fixed energy capacity and must collect
all litter cells 'L' in a grid.

Grid cells:
- S: starting position
- L: litter to collect
- R: reset area that restores full energy
- X: obstacle
- .: empty cell

Each move costs one unit of energy. Return the minimum moves required
to collect all litter, or -1 if it is impossible.

Approach:
Use Breadth-First Search with state compression.

State:
1. Current grid position
2. Bitmask representing collected litter
3. Remaining energy

For each (position, mask), retain the greatest remaining energy seen.
A higher-energy state dominates a lower-energy state with the same
position and collected litter.

Time Complexity: O(m * n * 2^L * energy)
Space Complexity: O(m * n * 2^L * energy)
*/

public class Minimum_Moves_to_Clean_the_Classroom {

    private static final int[] ROW_MOVE = {-1, 1, 0, 0};
    private static final int[] COL_MOVE = {0, 0, -1, 1};

    public static int minMoves(String[] classroom, int energy) {
        int rows = classroom.length;
        int cols = classroom[0].length();
        int cells = rows * cols;

        int[] litterAt = new int[cells];
        for (int index = 0; index < cells; index++) {
            litterAt[index] = -1;
        }

        int startPosition = -1;
        int litterCount = 0;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                char cell = classroom[row].charAt(col);
                int position = row * cols + col;

                if (cell == 'S') {
                    startPosition = position;
                } else if (cell == 'L') {
                    litterAt[position] = litterCount++;
                }
            }
        }

        if (litterCount == 0) {
            return 0;
        }

        int allCollectedMask = (1 << litterCount) - 1;
        int[][] bestEnergy = new int[1 << litterCount][cells];
        int energyBase = energy + 1;

        bestEnergy[0][startPosition] = energy + 1;

        IntQueue queue = new IntQueue();
        queue.offer(startPosition * energyBase + energy);

        int moves = 0;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            while (levelSize-- > 0) {
                int state = queue.poll();

                int remainingEnergy = state % energyBase;
                int value = state / energyBase;
                int position = value % cells;
                int collectedMask = value / cells;

                if (remainingEnergy == 0) {
                    continue;
                }

                int row = position / cols;
                int col = position % cols;

                for (int direction = 0; direction < 4; direction++) {
                    int nextRow = row + ROW_MOVE[direction];
                    int nextCol = col + COL_MOVE[direction];

                    if (nextRow < 0 || nextRow >= rows
                            || nextCol < 0 || nextCol >= cols
                            || classroom[nextRow].charAt(nextCol) == 'X') {
                        continue;
                    }

                    int nextPosition = nextRow * cols + nextCol;
                    int nextMask = collectedMask;

                    if (litterAt[nextPosition] != -1) {
                        nextMask |= 1 << litterAt[nextPosition];
                    }

                    int nextEnergy = remainingEnergy - 1;

                    if (classroom[nextRow].charAt(nextCol) == 'R') {
                        nextEnergy = energy;
                    }

                    if (nextMask == allCollectedMask) {
                        return moves + 1;
                    }

                    if (nextEnergy + 1 > bestEnergy[nextMask][nextPosition]) {
                        bestEnergy[nextMask][nextPosition] = nextEnergy + 1;

                        int nextState = ((nextMask * cells + nextPosition) * energyBase)
                                + nextEnergy;
                        queue.offer(nextState);
                    }
                }
            }

            moves++;
        }

        return -1;
    }

    private static class IntQueue {
        private int[] data = new int[1024];
        private int head = 0;
        private int tail = 0;
        private int size = 0;

        void offer(int value) {
            if (size == data.length) {
                grow();
            }

            data[tail] = value;
            tail = (tail + 1) % data.length;
            size++;
        }

        int poll() {
            int value = data[head];
            head = (head + 1) % data.length;
            size--;
            return value;
        }

        int size() {
            return size;
        }

        boolean isEmpty() {
            return size == 0;
        }

        private void grow() {
            int[] expanded = new int[data.length * 2];

            for (int index = 0; index < size; index++) {
                expanded[index] = data[(head + index) % data.length];
            }

            data = expanded;
            head = 0;
            tail = size;
        }
    }

    public static void main(String[] args) {
        String[] classroom1 = {"S.", "XL"};
        System.out.println(minMoves(classroom1, 2));
        // Expected Output: 2

        String[] classroom2 = {"LS", "RL"};
        System.out.println(minMoves(classroom2, 4));
        // Expected Output: 3

        String[] classroom3 = {"L.S", "RXL"};
        System.out.println(minMoves(classroom3, 3));
        // Expected Output: -1
    }
}