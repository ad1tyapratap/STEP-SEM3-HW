public class Q2_GalleryDescriptionCards {

    static abstract class ArtPiece {
        private static int counter = 0;
        private final String pieceId;

        public ArtPiece() {
            counter++;
            pieceId = "ART-" + counter;
        }

        public abstract String describe();

        public String getPieceId() {
            return pieceId;
        }
    }

    static class Painting extends ArtPiece {
        String title;

        public Painting(String title) {
            this.title = title;
        }

        @Override
        public String describe() {
            return "Painting: " + title + ", framed on canvas";
        }
    }

    static class Sculpture extends ArtPiece {
        String title;

        public Sculpture(String title) {
            this.title = title;
        }

        @Override
        public String describe() {
            return "Sculpture: " + title + ", carved from stone";
        }
    }

    public static void main(String[] args) {
        Painting p = new Painting("Sunset Fields");
        Sculpture s = new Sculpture("The Thinker II");

        System.out.println(p.describe());
        System.out.println(s.describe());

        System.out.println(p.getPieceId());
        System.out.println(s.getPieceId());
    }
}