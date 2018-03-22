package checkers.view;

public enum PieceType {
    RED(1), WHITE(-1);

    private final int moveDir;

    PieceType(int moveDir) {
        this.moveDir = moveDir;
    }

	public int getMoveDir() {
		return moveDir;
	}
}
