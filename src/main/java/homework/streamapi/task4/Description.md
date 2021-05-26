* Tasks:
* 1. Find best matching person - for ex;\
     If someone is looking for English with more\
     than 50% proficiency then we need to search for Person who's\
     proficiency is more than 50%. In the above example it is Gnanesh\
     who has 100% proficiency in English.
* 2. If none of the Person meets Given threshold (Case for Kannada in above example)\
     then find Technician who is best among rest ie Suresh in the above case (40%)

**For presentate your result write test for each case**

    List<Person> persons = new ArrayList<>();

        persons.add(new Person(1L, "Lokesh", new Skill("English", 10),
                new Skill("Kannada", 20), new Skill("Hindi", 10)));

        persons.add(new Person(2L, "Mahesh", new Skill("English", 10),
                new Skill("Kannada", 30), new Skill("Hindi", 50)));

        persons.add(new Person(3L, "Ganesh", new Skill("English", 10),
                new Skill("Kannada", 20), new Skill("Hindi", 40)));

        persons.add(new Person(4L, "Ramesh", new Skill("English", 10),
                new Skill("Kannada", 20), new Skill("Hindi", 40)));

        persons.add(new Person(5L, "Suresh", new Skill("English", 10),
                new Skill("Kannada", 40), new Skill("Hindi", 40)));

        persons.add(new Person(6L, "Gnanesh", new Skill("English", 100),
                new Skill("Kannada", 20), new Skill("Hindi", 40)));

