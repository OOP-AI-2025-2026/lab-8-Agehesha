package ua.opnu;

public class BookData implements Comparable<BookData> {
private final String title;
private final String author;
private final int reviews;
private final double total;

public BookData(String title, String author, int reviews, double total) {
    this.title = title;
    this.author = author;
    this.reviews = reviews;
    this.total = total;
}

public String getTitle() {
    return title;
}

public String getAuthor() {
    return author;
}

public int getReviews() {
    return reviews;
}

public double getTotal() {
    return total;
}

public double getRating() {
    return reviews == 0 ? 0.0 : total / reviews;
}

@Override
public int compareTo(BookData o) {
    double r1 = this.getRating();
    double r2 = o == null ? 0.0 : o.getRating();
    int cmp = Double.compare(r2, r1); // більший рейтинг -> "менший" (спочатку йде вище)
    if (cmp != 0) return cmp;
    String t1 = this.title == null ? "" : this.title;
    String t2 = (o == null || o.title == null) ? "" : o.title;
    return t1.compareTo(t2); // природний порядок за назвою
}

@Override
public String toString() {
    return "BookData{title='" + title + "', author='" + author + "', reviews=" + reviews +
            ", total=" + total + ", rating=" +
            String.format(java.util.Locale.US, "%.2f", getRating()) + "}";
}


}
