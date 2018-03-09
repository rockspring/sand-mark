服务端发生了CopycatError.Type.UNKNOWN_SESSION_ERROR错误

ClientSessionManager执行心跳服务。



客户端在session状态改变时如何处理，如何改变io.atomix.copycat.client.DefaultCopycatClient#state状态值：

private void onStateChange(Session.State state) {
    switch (state) {
      // When the session is opened, transition the state to CONNECTED.
      case OPEN:
        setState(State.CONNECTED);
        break;
      // When the session becomes unstable, transition the state to SUSPENDED.
      case UNSTABLE:
        setState(State.SUSPENDED);
        break;
      // When the session is expired, transition the state to SUSPENDED if necessary. The recovery strategy
      // must determine whether to attempt to recover the client.
      case EXPIRED:
        setState(State.SUSPENDED);
        recoveryStrategy.recover(this);
      case CLOSED:
        setState(State.CLOSED);
        break;
      default:
        break;
    }
  }