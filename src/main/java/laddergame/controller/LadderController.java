package laddergame.controller;

import laddergame.domain.ladder.Ladder;
import laddergame.domain.ladder.LadderHeight;
import laddergame.domain.player.Players;
import laddergame.dto.DrawnLadderDto;
import laddergame.exception.ExceptionHandler;
import laddergame.service.LadderGame;
import laddergame.view.InputView;
import laddergame.view.OutputView;

public class LadderController {

    private final InputView inputView;
    private final OutputView outputView;
    private final LadderGame ladderGame;

    public LadderController(final InputView inputView, final OutputView outputView, final LadderGame ladderGame) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.ladderGame = ladderGame;
    }

    public void run() {
        final Players players = getPlayers();
        final LadderHeight height = getLadderHeight();

        final Ladder ladder = ladderGame.createLadder(players, height);

        printDrawnLadder(players, ladder);
    }

    private Players getPlayers() {
        return ExceptionHandler.retryUntilInputIsValid(() -> new Players(inputView.readNames()), outputView);
    }

    private LadderHeight getLadderHeight() {
        return ExceptionHandler.retryUntilInputIsValid(() -> new LadderHeight(inputView.readLadderHeight()),
                outputView);
    }

    private void printDrawnLadder(final Players players, final Ladder ladder) {
        outputView.printResult(DrawnLadderDto.of(players, ladder));
    }

}
