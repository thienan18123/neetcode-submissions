class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        LinkedList<Integer> stack = new LinkedList<>();

        for (int asteroid : asteroids) {
            boolean alive = true;

            while (alive && asteroid < 0 && !stack.isEmpty() && stack.peekLast() > 0) {
                int head = stack.peekLast();

                if (head < Math.abs(asteroid)) {
                    stack.removeLast();
                } else if (head == Math.abs(asteroid)) {
                    stack.removeLast();
                    alive = false;
                } else {
                    alive = false;
                }
            }
            if (alive) {
                stack.addLast(asteroid);
            }
        }
        int[] result = new int[stack.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = stack.get(i);
        }

        return result;
        
    }
}