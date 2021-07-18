package stack_and_queue;

// 개와 고양이만 수용하는 동물 보호소 먼저 들어온 동물이 먼저 나간다.
public class AnimalShelter {
    private Animal first;
    private Animal last;

    private class Animal {
        private String type;
        private Animal next;

        public Animal(String type) {
            this.type = type;
        }
    }

    // 동물을 수용소에 넣음
    public void enqueue(String type) {

        Animal animal = new Animal(type);
        if (first == null) {
            first = animal;
            last = animal;
        } else {
            first.next = animal;
            first = animal;
        }
    }

    // 먼저 들어온 동물을 내보냄
    public String dequeueAny() {

        if (last == null) {
            return null;
        }
        String type = last.type;
        last = last.next;
        return type;
    }

    // 가장 오래된 강아지만 내보냄
    public String dequeueDog() {

        if (last == null) {
            return null;
        }

        String result = "";

        if (!last.type.equals("dog")) {
            Animal catBuffer = last;
            while (!last.type.equals("dog")) {
                last = last.next;
            }
            Animal dogBuffer = last;
            last = catBuffer;
            return dogBuffer.type;
        } else {
            result = last.type;
            last = last.next;
        }
        return result;
    }

    // 가장 오래된 고양이만 내보냄
    public String dequeueCat() {
        if (last == null) {
            return null;
        }

        String result = "";
        if (!last.type.equals("cat")) {
            Animal dogBuffer = last;
            while (!last.type.equals("cat")) {
                last = last.next;
            }
            Animal catBuffer = last;
            last = dogBuffer;
            return catBuffer.type;
        } else {
            result = last.type;
            last = last.next;
        }
        return result;
    }

    public static void main(String[] args) {
        AnimalShelter stack = new AnimalShelter();

        stack.enqueue("cat");
        stack.enqueue("dog");
        stack.enqueue("dog");
        stack.enqueue("cat");

        // in - - - cat dog dog cat - - > out
        System.out.println(stack.dequeueAny()); // cat out
        System.out.println(stack.dequeueAny()); // dog out
        System.out.println(stack.dequeueAny()); // dog out
        System.out.println(stack.dequeueAny()); // cat out
        System.out.println(stack.dequeueAny()); // cat out

    }

}
