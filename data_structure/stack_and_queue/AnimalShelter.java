package stack_and_queue;

// 큐에
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

    public String dequeueAny() {

        if (last == null) {
            return null;
        }
        String type = last.type;
        last = last.next;
        return type;
    }

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
