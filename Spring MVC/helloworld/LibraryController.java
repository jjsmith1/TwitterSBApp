
@Controller
public class LibraryController {
 @GetMapping(value="/library")
    public String displayLibrary(Model model) {
        List<String> books = new ArrayList<>();
        books.add("Gone girl");
         books.add("Gone girl");
         books.add("Gone girl");
         books.add("Gone girl");
 }
}
