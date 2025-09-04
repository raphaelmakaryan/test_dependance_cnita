package fr.raphaelmakaryan;

class FakeRealData implements IRealData {
    private int[] dataToReturn;

    public FakeRealData(int[] dataToReturn) {
        this.dataToReturn = dataToReturn;
    }

    @Override
    public int[] getData() {
        return dataToReturn;
    }
}