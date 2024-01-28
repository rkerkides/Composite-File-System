package file2923219;

public class Main {
    public static void main(String[] args) {
//        var root = new Directory("root");
//        var home = new Directory("home");
//        var opt = new Directory("opt");
//        var usr = new Directory("usr");
//        var file1 = new File("file1", 100);
//        var file2 = new File("file2", 200);
//        var file3 = new File("file3", 300);
//        var file4 = new File("file4", 400);
//
//        root.add(home);
//        root.add(opt);
//        root.add(usr);
//        home.add(file1);
//        home.add(file2);
//        opt.add(file3);
//        usr.add(file4);
//
//        System.out.println(root.display("\t"));
//
//        System.out.println(root.search("file1").getName() );
//
//        System.out.println(home.display("\t"));

        File courseworkpdf = new File("courseworkpdf",1);
        File courseworkzip = new File("coursework zip file",2);

        Directory coursework = new Directory("coursework");
        coursework.add(courseworkpdf);
        coursework.add(courseworkzip);

        Directory unittests = new Directory("unit tests");
        File test1 = new File("unit test 1",56);
        unittests.add(test1);

        coursework.add(unittests);
        coursework.remove(courseworkzip);
        System.out.println(coursework.display("\t"));
        System.out.println(coursework.display("+-"));

        System.out.println( coursework.search("unit test 1").getName() );
    }
}