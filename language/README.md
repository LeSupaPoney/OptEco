# Language
* [English](lang.yml)
* [Vietnamese](lang_vi.yml)
* [Chinese](lang_cn.yml)
* [Czech](language_cs.yml)

Just copy and paste into `lang.yml` file. It'll work fine!
# Language example
    # Default prefix
    PREFIX: '&e[OptEco]'
    # Display when player request an no-permission command
    NO_PERMISSIONS: '&cYou have no permission to require this action.'
    # Display when command not found
    COMMAND_NOT_FOUND: '&cCommand not found.'
    # Display player command while using command in console 
    FOR_PLAYER: '&cThis command just for player, console cannot use this.'
    COMMAND:
      VAR_AMOUNT: <amount>
      VAR_NOT_A_NUMBER: '&cValue %value% is not a number.'
      VAR_PLAYER: <player>
      VAR_VALUE_CANNOT_BE_NEGATIVE: '&cThe amount cannot be negative.'
      PLAYER_NOT_FOUND: '&cCannot found player %who% in server.'
      ADD:
        DESCRIPTION: add balance to player
        SUCCEEDED: '&aSucceeded add &d%value% %currency% &ainto &d%who% &aaccount.'
        FAILED: '&cFailed to add &d%value% %currency% &ainto &d%who% &aaccount.'
      CHECK:
        DESCRIPTION: check player balance
        SELF: '&aYour balance now is &d%value% %currency%'
        ANOTHER: '&aPlayer %who% balance now is &d%value% %currency%'
      ME:
        DESCRIPTION: check my balance
      PAY:
        DESCRIPTION: transfer points to player
        PAY_ON_TRANSACTION: '&cYou are on transaction with another player, please using
          &d/points [confirm/cancel] &cto confirm your before transaction.'
        CONFIRM_DISPLAY: '&aYou have &d%value% seconds &ato confirm, please using &d/points
          [confirm/cancel] &ato confirm your transaction.'
        OUT_OF_TIME_CONFIRM: '&cYou are out of time to confirm your transaction.'
        NOT_ENOUGH: '&cNot enough to pay.'
        PAY_CANNOT_SELF_TRANSFER: '&cYou cannot transfer to yourself.'
        PAY_TRANSACTION_NOT_EXIST: '&cYou have not paid for everybody.'
        ACCEPTED: '&aTransfer &d%value% %currency% &ato &d%who%.'
        ACCEPTED_TARGET: '&aYou has been received &d%value% %currency% &aby &d%who%'
        FAILED: '&cHaving an error while pending transferred.'
        DENY: '&cYou are denied the transaction.'
      RELOAD:
        DESCRIPTION: reload plugin
        DONE: '&aReloaded all config.'
      TAKE:
        DESCRIPTION: take player points
        SUCCESS: '&aTaking &d%value% %currency% &afrom &d%who%'
        FAIL: '&aCannot take &d%value% %currency% &afrom &d%who% &abecause of the error!'
      SET:
        DESCRIPTION: set player points
        SUCCESS: '&aSetting &d%value% %currency% &ato &d%who%'
        FAIL: '&aCannot set &d%value% %currency% &ato &d%who% &abecause of the error!'
      CONFIRM:
        DESCRIPTION: confirm transaction
      CANCEL:
        DESCRIPTION: cancel transaction
