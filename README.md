#Headfirst Into Java Notes

**CHAPTER 5**
- When making a class:
  1. Sketch a rough idea (pseudocode).
  2. Make a tester to check if it works.
  3. Write the actual code.
- Extreme programming (XP) tips:
  - Test first, then code.
  - Work in pairs and swap partners often.
  - Make regular small updates.
  - Keep it simple.
  - If you know how many times you'll loop, use 'for loops'.
  - You can change data types, like from 'long' to 'int'.

**CHAPTER 6**
- Java API is like a toolbox with ready-to-use parts.
- Classes in Java API belong to groups (packages).
- ArrayLists are like flexible lists. They can't hold basic data types directly but can hold their object versions.
- There are shortcuts in programming (like '&&' and '||') that can save time.
- If unsure about a tool or class, look it up online.

**CHAPTER 7**
- Plan apps thinking about the future.
- Classes can inherit (borrow) stuff from other classes. 
- There are two types of relationships between classes: one is like a child-parent (IS-A) and the other like friendship (HAS-A).
- Who can see and use parts of your code? That's set by access levels: private (most restricted) to public (everyone can see).
- Classes can be general (superclass) or specific (subclass).
- There's a difference between tweaking a method's role (overriding) and having two methods with the same name but different tasks (overloading).

**CHAPTER 8**
- Some classes are just templates. They're abstract (you can't create an "object" from them).
- Interfaces are like to-do lists for classes. 
- Every class is, in a way, a child of a big "object" class.
- You can't have a class with two parent classes. But classes can follow multiple to-do lists (interfaces).
- Choose between making a simple class, a more specific one, a template, or a to-do list based on your needs.

**CHAPTER 9**
- Variables in objects are stored in a place called the Heap.
- Constructors are special methods that set up new objects.
- If you don't define how a new object should be set up, Java will use a basic setup.
- If you want different ways to set up an object, you can define multiple constructors.
- If you don't give a variable an initial value, Java will set a default one for you.