package LMS;

public enum BookType {
        FICTION(SpotType.UPPER_LEVEL),
        NON_FICTION(SpotType.UPPER_LEVEL),
        SCIENCE(SpotType.UPPER_LEVEL),
        MYSTERY(SpotType.LOWER_LEVEL),
        ROMANCE(SpotType.LOWER_LEVEL),
        HISTORY(SpotType.MIDDLE_LEVEL),
        FANTASY(SpotType.MIDDLE_LEVEL),
        BIOGRAPHY(SpotType.MIDDLE_LEVEL);

        private final SpotType spotType;

        BookType(SpotType spotType) {
                this.spotType = spotType;
        }

        public SpotType getSpotType() {
                return spotType;
        }
}

