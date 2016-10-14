package SimpleOpenNI;

public class ContextWrapper
{
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;
  
  protected ContextWrapper(long paramLong, boolean paramBoolean)
  {
    this.swigCMemOwn = paramBoolean;
    this.swigCPtr = paramLong;
  }
  
  protected static long getCPtr(ContextWrapper paramContextWrapper)
  {
    return paramContextWrapper == null ? 0L : paramContextWrapper.swigCPtr;
  }
  
  @Override
protected void finalize()
  {
    delete();
  }
  
  public synchronized void delete()
  {
    if (this.swigCPtr != 0L)
    {
      if (this.swigCMemOwn)
      {
        this.swigCMemOwn = false;
        SimpleOpenNIJNI.delete_ContextWrapper(this.swigCPtr);
      }
      this.swigCPtr = 0L;
    }
  }
  
  protected void swigDirectorDisconnect()
  {
    this.swigCMemOwn = false;
    delete();
  }
  
  public void swigReleaseOwnership()
  {
    this.swigCMemOwn = false;
    SimpleOpenNIJNI.ContextWrapper_change_ownership(this, this.swigCPtr, false);
  }
  
  public void swigTakeOwnership()
  {
    this.swigCMemOwn = true;
    SimpleOpenNIJNI.ContextWrapper_change_ownership(this, this.swigCPtr, true);
  }
  
  public ContextWrapper()
  {
    this(SimpleOpenNIJNI.new_ContextWrapper(), true);
    SimpleOpenNIJNI.ContextWrapper_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
  }
  
  public int version()
  {
    return SimpleOpenNIJNI.ContextWrapper_version(this.swigCPtr, this);
  }
  
  public static void chdir(String paramString)
  {
    SimpleOpenNIJNI.ContextWrapper_chdir(paramString);
  }
  
  public static String getcwd()
  {
    return SimpleOpenNIJNI.ContextWrapper_getcwd();
  }
  
  public static boolean initContext()
  {
    return SimpleOpenNIJNI.ContextWrapper_initContext();
  }
  
  public boolean init(int paramInt)
  {
    return SimpleOpenNIJNI.ContextWrapper_init__SWIG_0(this.swigCPtr, this, paramInt);
  }
  
  public boolean init()
  {
    return SimpleOpenNIJNI.ContextWrapper_init__SWIG_1(this.swigCPtr, this);
  }
  
  public boolean init(String paramString, int paramInt)
  {
    return SimpleOpenNIJNI.ContextWrapper_init__SWIG_2(this.swigCPtr, this, paramString, paramInt);
  }
  
  public boolean init(String paramString)
  {
    return SimpleOpenNIJNI.ContextWrapper_init__SWIG_3(this.swigCPtr, this, paramString);
  }
  
  public boolean init(int paramInt1, int paramInt2)
  {
    return SimpleOpenNIJNI.ContextWrapper_init__SWIG_4(this.swigCPtr, this, paramInt1, paramInt2);
  }
  
  public int nodes()
  {
    return SimpleOpenNIJNI.ContextWrapper_nodes(this.swigCPtr, this);
  }
  
  public static int deviceCount()
  {
    return SimpleOpenNIJNI.ContextWrapper_deviceCount();
  }
  
  public static int deviceNames(StrVector paramStrVector)
  {
    return SimpleOpenNIJNI.ContextWrapper_deviceNames(StrVector.getCPtr(paramStrVector), paramStrVector);
  }
  
  public int deviceIndex()
  {
    return SimpleOpenNIJNI.ContextWrapper_deviceIndex(this.swigCPtr, this);
  }
  
  public boolean isInit()
  {
    return SimpleOpenNIJNI.ContextWrapper_isInit(this.swigCPtr, this);
  }
  
  public void close()
  {
    SimpleOpenNIJNI.ContextWrapper_close(this.swigCPtr, this);
  }
  
  public boolean enableDepth()
  {
    return getClass() == ContextWrapper.class ? SimpleOpenNIJNI.ContextWrapper_enableDepth__SWIG_0(this.swigCPtr, this) : SimpleOpenNIJNI.ContextWrapper_enableDepthSwigExplicitContextWrapper__SWIG_0(this.swigCPtr, this);
  }
  
  public boolean enableDepth(int paramInt1, int paramInt2, int paramInt3)
  {
    return getClass() == ContextWrapper.class ? SimpleOpenNIJNI.ContextWrapper_enableDepth__SWIG_1(this.swigCPtr, this, paramInt1, paramInt2, paramInt3) : SimpleOpenNIJNI.ContextWrapper_enableDepthSwigExplicitContextWrapper__SWIG_1(this.swigCPtr, this, paramInt1, paramInt2, paramInt3);
  }
  
  public boolean enableRGB()
  {
    return getClass() == ContextWrapper.class ? SimpleOpenNIJNI.ContextWrapper_enableRGB__SWIG_0(this.swigCPtr, this) : SimpleOpenNIJNI.ContextWrapper_enableRGBSwigExplicitContextWrapper__SWIG_0(this.swigCPtr, this);
  }
  
  public boolean enableRGB(int paramInt1, int paramInt2, int paramInt3)
  {
    return getClass() == ContextWrapper.class ? SimpleOpenNIJNI.ContextWrapper_enableRGB__SWIG_1(this.swigCPtr, this, paramInt1, paramInt2, paramInt3) : SimpleOpenNIJNI.ContextWrapper_enableRGBSwigExplicitContextWrapper__SWIG_1(this.swigCPtr, this, paramInt1, paramInt2, paramInt3);
  }
  
  public boolean enableIR()
  {
    return getClass() == ContextWrapper.class ? SimpleOpenNIJNI.ContextWrapper_enableIR__SWIG_0(this.swigCPtr, this) : SimpleOpenNIJNI.ContextWrapper_enableIRSwigExplicitContextWrapper__SWIG_0(this.swigCPtr, this);
  }
  
  public boolean enableIR(int paramInt1, int paramInt2, int paramInt3)
  {
    return getClass() == ContextWrapper.class ? SimpleOpenNIJNI.ContextWrapper_enableIR__SWIG_1(this.swigCPtr, this, paramInt1, paramInt2, paramInt3) : SimpleOpenNIJNI.ContextWrapper_enableIRSwigExplicitContextWrapper__SWIG_1(this.swigCPtr, this, paramInt1, paramInt2, paramInt3);
  }
  
  public boolean enableUser()
  {
    return getClass() == ContextWrapper.class ? SimpleOpenNIJNI.ContextWrapper_enableUser(this.swigCPtr, this) : SimpleOpenNIJNI.ContextWrapper_enableUserSwigExplicitContextWrapper(this.swigCPtr, this);
  }
  
  public boolean enableHand()
  {
    return getClass() == ContextWrapper.class ? SimpleOpenNIJNI.ContextWrapper_enableHand(this.swigCPtr, this) : SimpleOpenNIJNI.ContextWrapper_enableHandSwigExplicitContextWrapper(this.swigCPtr, this);
  }
  
  public void update()
  {
    if (getClass() == ContextWrapper.class) {
      SimpleOpenNIJNI.ContextWrapper_update(this.swigCPtr, this);
    } else {
      SimpleOpenNIJNI.ContextWrapper_updateSwigExplicitContextWrapper(this.swigCPtr, this);
    }
  }
  
  public static void updateAll() {}
  
  public int depthWidth()
  {
    return SimpleOpenNIJNI.ContextWrapper_depthWidth(this.swigCPtr, this);
  }
  
  public int depthHeight()
  {
    return SimpleOpenNIJNI.ContextWrapper_depthHeight(this.swigCPtr, this);
  }
  
  public int depthImage(int[] paramArrayOfInt)
  {
    return SimpleOpenNIJNI.ContextWrapper_depthImage(this.swigCPtr, this, paramArrayOfInt);
  }
  
  public void setDepthImageColor(int paramInt1, int paramInt2, int paramInt3)
  {
    SimpleOpenNIJNI.ContextWrapper_setDepthImageColor(this.swigCPtr, this, paramInt1, paramInt2, paramInt3);
  }
  
  public void setDepthImageColorMode(int paramInt)
  {
    SimpleOpenNIJNI.ContextWrapper_setDepthImageColorMode(this.swigCPtr, this, paramInt);
  }
  
  public int depthImageColorMode()
  {
    return SimpleOpenNIJNI.ContextWrapper_depthImageColorMode(this.swigCPtr, this);
  }
  
  public int depthMapSize()
  {
    return SimpleOpenNIJNI.ContextWrapper_depthMapSize(this.swigCPtr, this);
  }
  
  public int depthMap(int[] paramArrayOfInt)
  {
    return SimpleOpenNIJNI.ContextWrapper_depthMap(this.swigCPtr, this, paramArrayOfInt);
  }
  
  public int depthMapRealWorld(float[] paramArrayOfFloat)
  {
    return SimpleOpenNIJNI.ContextWrapper_depthMapRealWorld(this.swigCPtr, this, paramArrayOfFloat);
  }
  
  public float hFieldOfView()
  {
    return SimpleOpenNIJNI.ContextWrapper_hFieldOfView(this.swigCPtr, this);
  }
  
  public float vFieldOfView()
  {
    return SimpleOpenNIJNI.ContextWrapper_vFieldOfView(this.swigCPtr, this);
  }
  
  public int rgbWidth()
  {
    return SimpleOpenNIJNI.ContextWrapper_rgbWidth(this.swigCPtr, this);
  }
  
  public int rgbHeight()
  {
    return SimpleOpenNIJNI.ContextWrapper_rgbHeight(this.swigCPtr, this);
  }
  
  public int rgbImage(int[] paramArrayOfInt)
  {
    return SimpleOpenNIJNI.ContextWrapper_rgbImage(this.swigCPtr, this, paramArrayOfInt);
  }
  
  public int irWidth()
  {
    return SimpleOpenNIJNI.ContextWrapper_irWidth(this.swigCPtr, this);
  }
  
  public int irHeight()
  {
    return SimpleOpenNIJNI.ContextWrapper_irHeight(this.swigCPtr, this);
  }
  
  public int irMap(int[] paramArrayOfInt)
  {
    return SimpleOpenNIJNI.ContextWrapper_irMap(this.swigCPtr, this, paramArrayOfInt);
  }
  
  public int irImage(int[] paramArrayOfInt)
  {
    return SimpleOpenNIJNI.ContextWrapper_irImage(this.swigCPtr, this, paramArrayOfInt);
  }
  
  public int userWidth()
  {
    return SimpleOpenNIJNI.ContextWrapper_userWidth(this.swigCPtr, this);
  }
  
  public int userHeight()
  {
    return SimpleOpenNIJNI.ContextWrapper_userHeight(this.swigCPtr, this);
  }
  
  public boolean getCoM(int paramInt, float[] paramArrayOfFloat)
  {
    return SimpleOpenNIJNI.ContextWrapper_getCoM(this.swigCPtr, this, paramInt, paramArrayOfFloat);
  }
  
  public boolean getBoundingBox(int paramInt, float[] paramArrayOfFloat)
  {
    return SimpleOpenNIJNI.ContextWrapper_getBoundingBox(this.swigCPtr, this, paramInt, paramArrayOfFloat);
  }
  
  public int getNumberOfUsers()
  {
    return SimpleOpenNIJNI.ContextWrapper_getNumberOfUsers(this.swigCPtr, this);
  }
  
  public int getUsers(IntVector paramIntVector)
  {
    return SimpleOpenNIJNI.ContextWrapper_getUsers(this.swigCPtr, this, IntVector.getCPtr(paramIntVector), paramIntVector);
  }
  
  public int userMap(int[] paramArrayOfInt)
  {
    return SimpleOpenNIJNI.ContextWrapper_userMap(this.swigCPtr, this, paramArrayOfInt);
  }
  
  public int userImage(int[] paramArrayOfInt)
  {
    return SimpleOpenNIJNI.ContextWrapper_userImage(this.swigCPtr, this, paramArrayOfInt);
  }
  
  public boolean isTrackingSkeleton(int paramInt)
  {
    return SimpleOpenNIJNI.ContextWrapper_isTrackingSkeleton(this.swigCPtr, this, paramInt);
  }
  
  public void startTrackingSkeleton(int paramInt)
  {
    SimpleOpenNIJNI.ContextWrapper_startTrackingSkeleton(this.swigCPtr, this, paramInt);
  }
  
  public void stopTrackingSkeleton(int paramInt)
  {
    SimpleOpenNIJNI.ContextWrapper_stopTrackingSkeleton(this.swigCPtr, this, paramInt);
  }
  
  public float getJointPositionSkeleton(int paramInt1, int paramInt2, float[] paramArrayOfFloat)
  {
    return SimpleOpenNIJNI.ContextWrapper_getJointPositionSkeleton(this.swigCPtr, this, paramInt1, paramInt2, paramArrayOfFloat);
  }
  
  public float getJointOrientationSkeleton(int paramInt1, int paramInt2, float[] paramArrayOfFloat)
  {
    return SimpleOpenNIJNI.ContextWrapper_getJointOrientationSkeleton(this.swigCPtr, this, paramInt1, paramInt2, paramArrayOfFloat);
  }
  
  public int startTrackingHand(float[] paramArrayOfFloat)
  {
    return SimpleOpenNIJNI.ContextWrapper_startTrackingHand(this.swigCPtr, this, paramArrayOfFloat);
  }
  
  public void stopTrackingHand(int paramInt)
  {
    SimpleOpenNIJNI.ContextWrapper_stopTrackingHand(this.swigCPtr, this, paramInt);
  }
  
  public void stopTrackingAllHand()
  {
    SimpleOpenNIJNI.ContextWrapper_stopTrackingAllHand(this.swigCPtr, this);
  }
  
  public void setSmoothingHand(float paramFloat)
  {
    SimpleOpenNIJNI.ContextWrapper_setSmoothingHand(this.swigCPtr, this, paramFloat);
  }
  
  public float getSmoothingHand()
  {
    return SimpleOpenNIJNI.ContextWrapper_getSmoothingHand(this.swigCPtr, this);
  }
  
  public void startGesture(int paramInt)
  {
    SimpleOpenNIJNI.ContextWrapper_startGesture(this.swigCPtr, this, paramInt);
  }
  
  public void endGesture(int paramInt)
  {
    SimpleOpenNIJNI.ContextWrapper_endGesture(this.swigCPtr, this, paramInt);
  }
  
  public boolean enableRecorder(String paramString)
  {
    return getClass() == ContextWrapper.class ? SimpleOpenNIJNI.ContextWrapper_enableRecorder(this.swigCPtr, this, paramString) : SimpleOpenNIJNI.ContextWrapper_enableRecorderSwigExplicitContextWrapper(this.swigCPtr, this, paramString);
  }
  
  public boolean addNodeToRecording(int paramInt, boolean paramBoolean)
  {
    return SimpleOpenNIJNI.ContextWrapper_addNodeToRecording(this.swigCPtr, this, paramInt, paramBoolean);
  }
  
  public boolean openFileRecording(String paramString)
  {
    return getClass() == ContextWrapper.class ? SimpleOpenNIJNI.ContextWrapper_openFileRecording(this.swigCPtr, this, paramString) : SimpleOpenNIJNI.ContextWrapper_openFileRecordingSwigExplicitContextWrapper(this.swigCPtr, this, paramString);
  }
  
  public void playbackPlay(boolean paramBoolean)
  {
    SimpleOpenNIJNI.ContextWrapper_playbackPlay(this.swigCPtr, this, paramBoolean);
  }
  
  public boolean isPlaybackPlay()
  {
    return SimpleOpenNIJNI.ContextWrapper_isPlaybackPlay(this.swigCPtr, this);
  }
  
  public void setPlaybackSpeedPlayer(float paramFloat)
  {
    SimpleOpenNIJNI.ContextWrapper_setPlaybackSpeedPlayer(this.swigCPtr, this, paramFloat);
  }
  
  public float playbackSpeedPlayer()
  {
    return SimpleOpenNIJNI.ContextWrapper_playbackSpeedPlayer(this.swigCPtr, this);
  }
  
  public void setRepeatPlayer(boolean paramBoolean)
  {
    SimpleOpenNIJNI.ContextWrapper_setRepeatPlayer(this.swigCPtr, this, paramBoolean);
  }
  
  public boolean repeatPlayer()
  {
    return SimpleOpenNIJNI.ContextWrapper_repeatPlayer(this.swigCPtr, this);
  }
  
  public int curFramePlayer()
  {
    return SimpleOpenNIJNI.ContextWrapper_curFramePlayer(this.swigCPtr, this);
  }
  
  public int framesPlayer()
  {
    return SimpleOpenNIJNI.ContextWrapper_framesPlayer(this.swigCPtr, this);
  }
  
  public void seekPlayer(int paramInt)
  {
    SimpleOpenNIJNI.ContextWrapper_seekPlayer(this.swigCPtr, this, paramInt);
  }
  
  public boolean isEndPlayer()
  {
    return SimpleOpenNIJNI.ContextWrapper_isEndPlayer(this.swigCPtr, this);
  }
  
  public void setMirror(boolean paramBoolean)
  {
    SimpleOpenNIJNI.ContextWrapper_setMirror(this.swigCPtr, this, paramBoolean);
  }
  
  public boolean mirror()
  {
    return SimpleOpenNIJNI.ContextWrapper_mirror(this.swigCPtr, this);
  }
  
  public void convertRealWorldToProjective(float paramFloat1, float paramFloat2, float paramFloat3, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float[] paramArrayOfFloat3)
  {
    SimpleOpenNIJNI.ContextWrapper_convertRealWorldToProjective__SWIG_0(this.swigCPtr, this, paramFloat1, paramFloat2, paramFloat3, paramArrayOfFloat1, paramArrayOfFloat2, paramArrayOfFloat3);
  }
  
  public void convertRealWorldToProjective(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    SimpleOpenNIJNI.ContextWrapper_convertRealWorldToProjective__SWIG_1(this.swigCPtr, this, paramArrayOfFloat1, paramArrayOfFloat2);
  }
  
  public void convertProjectiveToRealWorld(float paramFloat1, float paramFloat2, float paramFloat3, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float[] paramArrayOfFloat3)
  {
    SimpleOpenNIJNI.ContextWrapper_convertProjectiveToRealWorld__SWIG_0(this.swigCPtr, this, paramFloat1, paramFloat2, paramFloat3, paramArrayOfFloat1, paramArrayOfFloat2, paramArrayOfFloat3);
  }
  
  public void convertProjectiveToRealWorld(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    SimpleOpenNIJNI.ContextWrapper_convertProjectiveToRealWorld__SWIG_1(this.swigCPtr, this, paramArrayOfFloat1, paramArrayOfFloat2);
  }
  
  public boolean alternativeViewPointDepthToImage()
  {
    return SimpleOpenNIJNI.ContextWrapper_alternativeViewPointDepthToImage(this.swigCPtr, this);
  }
  
  public boolean setDepthToColor(boolean paramBoolean)
  {
    return SimpleOpenNIJNI.ContextWrapper_setDepthToColor(this.swigCPtr, this, paramBoolean);
  }
  
  public boolean depthToColor()
  {
    return SimpleOpenNIJNI.ContextWrapper_depthToColor(this.swigCPtr, this);
  }
  
  public boolean setDepthColorSyncEnabled(boolean paramBoolean)
  {
    return SimpleOpenNIJNI.ContextWrapper_setDepthColorSyncEnabled(this.swigCPtr, this, paramBoolean);
  }
  
  public void setUserCoordsys(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9)
  {
    SimpleOpenNIJNI.ContextWrapper_setUserCoordsys(this.swigCPtr, this, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramFloat7, paramFloat8, paramFloat9);
  }
  
  public void resetUserCoordsys()
  {
    SimpleOpenNIJNI.ContextWrapper_resetUserCoordsys(this.swigCPtr, this);
  }
  
  public boolean hasUserCoordsys()
  {
    return SimpleOpenNIJNI.ContextWrapper_hasUserCoordsys(this.swigCPtr, this);
  }
  
  public void getUserCoordsysTransMat(float[] paramArrayOfFloat)
  {
    SimpleOpenNIJNI.ContextWrapper_getUserCoordsysTransMat(this.swigCPtr, this, paramArrayOfFloat);
  }
  
  public void calcUserCoordsys(float[] paramArrayOfFloat)
  {
    SimpleOpenNIJNI.ContextWrapper_calcUserCoordsys(this.swigCPtr, this, paramArrayOfFloat);
  }
  
  public void calcUserCoordsysMat(float[] paramArrayOfFloat)
  {
    SimpleOpenNIJNI.ContextWrapper_calcUserCoordsysMat(this.swigCPtr, this, paramArrayOfFloat);
  }
  
  public void calcUserCoordsysBack(float[] paramArrayOfFloat)
  {
    SimpleOpenNIJNI.ContextWrapper_calcUserCoordsysBack(this.swigCPtr, this, paramArrayOfFloat);
  }
  
  public void calcUserCoordsysBackMat(float[] paramArrayOfFloat)
  {
    SimpleOpenNIJNI.ContextWrapper_calcUserCoordsysBackMat(this.swigCPtr, this, paramArrayOfFloat);
  }
  
  public void getUserCoordsys(float[] paramArrayOfFloat)
  {
    SimpleOpenNIJNI.ContextWrapper_getUserCoordsys(this.swigCPtr, this, paramArrayOfFloat);
  }
  
  public void getUserCoordsysBack(float[] paramArrayOfFloat)
  {
    SimpleOpenNIJNI.ContextWrapper_getUserCoordsysBack(this.swigCPtr, this, paramArrayOfFloat);
  }
  
  public static boolean rayTriangleIntersection(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float[] paramArrayOfFloat3, float[] paramArrayOfFloat4, float[] paramArrayOfFloat5, float[] paramArrayOfFloat6)
  {
    return SimpleOpenNIJNI.ContextWrapper_rayTriangleIntersection(paramArrayOfFloat1, paramArrayOfFloat2, paramArrayOfFloat3, paramArrayOfFloat4, paramArrayOfFloat5, paramArrayOfFloat6);
  }
  
  public static int raySphereIntersection(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float[] paramArrayOfFloat3, float paramFloat, float[] paramArrayOfFloat4, float[] paramArrayOfFloat5)
  {
    return SimpleOpenNIJNI.ContextWrapper_raySphereIntersection(paramArrayOfFloat1, paramArrayOfFloat2, paramArrayOfFloat3, paramFloat, paramArrayOfFloat4, paramArrayOfFloat5);
  }
  
  public long depthMapTimeStamp()
  {
    return SimpleOpenNIJNI.ContextWrapper_depthMapTimeStamp(this.swigCPtr, this);
  }
  
  public long depthImageTimeStamp()
  {
    return SimpleOpenNIJNI.ContextWrapper_depthImageTimeStamp(this.swigCPtr, this);
  }
  
  public long depthRealWorldTimeStamp()
  {
    return SimpleOpenNIJNI.ContextWrapper_depthRealWorldTimeStamp(this.swigCPtr, this);
  }
  
  public long imageTimeStamp()
  {
    return SimpleOpenNIJNI.ContextWrapper_imageTimeStamp(this.swigCPtr, this);
  }
  
  public long irTimeStamp()
  {
    return SimpleOpenNIJNI.ContextWrapper_irTimeStamp(this.swigCPtr, this);
  }
  
  public long sceneTimeStamp()
  {
    return SimpleOpenNIJNI.ContextWrapper_sceneTimeStamp(this.swigCPtr, this);
  }
  
  public long userTimeStamp()
  {
    return SimpleOpenNIJNI.ContextWrapper_userTimeStamp(this.swigCPtr, this);
  }
  
  public long handTimeStamp()
  {
    return SimpleOpenNIJNI.ContextWrapper_handTimeStamp(this.swigCPtr, this);
  }
  
  public long updateTimeStamp()
  {
    return SimpleOpenNIJNI.ContextWrapper_updateTimeStamp(this.swigCPtr, this);
  }
  
  public long updateSubTimeStamp()
  {
    return SimpleOpenNIJNI.ContextWrapper_updateSubTimeStamp(this.swigCPtr, this);
  }
  
  protected void onNewUserCb(int paramInt)
  {
    if (getClass() == ContextWrapper.class) {
      SimpleOpenNIJNI.ContextWrapper_onNewUserCb(this.swigCPtr, this, paramInt);
    } else {
      SimpleOpenNIJNI.ContextWrapper_onNewUserCbSwigExplicitContextWrapper(this.swigCPtr, this, paramInt);
    }
  }
  
  protected void onLostUserCb(int paramInt)
  {
    if (getClass() == ContextWrapper.class) {
      SimpleOpenNIJNI.ContextWrapper_onLostUserCb(this.swigCPtr, this, paramInt);
    } else {
      SimpleOpenNIJNI.ContextWrapper_onLostUserCbSwigExplicitContextWrapper(this.swigCPtr, this, paramInt);
    }
  }
  
  protected void onVisibleUserCb(int paramInt)
  {
    if (getClass() == ContextWrapper.class) {
      SimpleOpenNIJNI.ContextWrapper_onVisibleUserCb(this.swigCPtr, this, paramInt);
    } else {
      SimpleOpenNIJNI.ContextWrapper_onVisibleUserCbSwigExplicitContextWrapper(this.swigCPtr, this, paramInt);
    }
  }
  
  protected void onOutOfSceneUserCb(int paramInt)
  {
    if (getClass() == ContextWrapper.class) {
      SimpleOpenNIJNI.ContextWrapper_onOutOfSceneUserCb(this.swigCPtr, this, paramInt);
    } else {
      SimpleOpenNIJNI.ContextWrapper_onOutOfSceneUserCbSwigExplicitContextWrapper(this.swigCPtr, this, paramInt);
    }
  }
  
  protected void onNewHandCb(int paramInt, Vec3f paramVec3f)
  {
    if (getClass() == ContextWrapper.class) {
      SimpleOpenNIJNI.ContextWrapper_onNewHandCb(this.swigCPtr, this, paramInt, Vec3f.getCPtr(paramVec3f), paramVec3f);
    } else {
      SimpleOpenNIJNI.ContextWrapper_onNewHandCbSwigExplicitContextWrapper(this.swigCPtr, this, paramInt, Vec3f.getCPtr(paramVec3f), paramVec3f);
    }
  }
  
  protected void onTrackedHandCb(int paramInt, Vec3f paramVec3f)
  {
    if (getClass() == ContextWrapper.class) {
      SimpleOpenNIJNI.ContextWrapper_onTrackedHandCb(this.swigCPtr, this, paramInt, Vec3f.getCPtr(paramVec3f), paramVec3f);
    } else {
      SimpleOpenNIJNI.ContextWrapper_onTrackedHandCbSwigExplicitContextWrapper(this.swigCPtr, this, paramInt, Vec3f.getCPtr(paramVec3f), paramVec3f);
    }
  }
  
  protected void onLostHandCb(int paramInt)
  {
    if (getClass() == ContextWrapper.class) {
      SimpleOpenNIJNI.ContextWrapper_onLostHandCb(this.swigCPtr, this, paramInt);
    } else {
      SimpleOpenNIJNI.ContextWrapper_onLostHandCbSwigExplicitContextWrapper(this.swigCPtr, this, paramInt);
    }
  }
  
  protected void onNewGestureCb(int paramInt)
  {
    if (getClass() == ContextWrapper.class) {
      SimpleOpenNIJNI.ContextWrapper_onNewGestureCb(this.swigCPtr, this, paramInt);
    } else {
      SimpleOpenNIJNI.ContextWrapper_onNewGestureCbSwigExplicitContextWrapper(this.swigCPtr, this, paramInt);
    }
  }
  
  protected void onInProgressGestureCb(int paramInt)
  {
    if (getClass() == ContextWrapper.class) {
      SimpleOpenNIJNI.ContextWrapper_onInProgressGestureCb(this.swigCPtr, this, paramInt);
    } else {
      SimpleOpenNIJNI.ContextWrapper_onInProgressGestureCbSwigExplicitContextWrapper(this.swigCPtr, this, paramInt);
    }
  }
  
  protected void onAbortedGestureCb(int paramInt)
  {
    if (getClass() == ContextWrapper.class) {
      SimpleOpenNIJNI.ContextWrapper_onAbortedGestureCb(this.swigCPtr, this, paramInt);
    } else {
      SimpleOpenNIJNI.ContextWrapper_onAbortedGestureCbSwigExplicitContextWrapper(this.swigCPtr, this, paramInt);
    }
  }
  
  protected void onCompletedGestureCb(int paramInt, Vec3f paramVec3f)
  {
    if (getClass() == ContextWrapper.class) {
      SimpleOpenNIJNI.ContextWrapper_onCompletedGestureCb(this.swigCPtr, this, paramInt, Vec3f.getCPtr(paramVec3f), paramVec3f);
    } else {
      SimpleOpenNIJNI.ContextWrapper_onCompletedGestureCbSwigExplicitContextWrapper(this.swigCPtr, this, paramInt, Vec3f.getCPtr(paramVec3f), paramVec3f);
    }
  }
}
