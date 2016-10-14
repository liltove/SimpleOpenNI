package SimpleOpenNI;

import java.lang.reflect.Method;
import java.net.URL;
import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PMatrix3D;
import processing.core.PVector;

public class SimpleOpenNI
  extends ContextWrapper
  implements SimpleOpenNIConstants
{
  static String workingDir = System.getProperty("user.dir");
  static String nativDepLibPath = "";
  static String nativLibPath = "";
  protected Object _userCbObject;
  protected Object _calibrationCbObject;
  protected Object _poseCbObject;
  protected Object _handCbObject;
  protected Object _gestureCbObject;
  protected Object _sessionCbObject;
  protected Method _newUserMethod;
  protected Method _lostUserMethod;
  protected Method _outOfSceneUserMethod;
  protected Method _visibleUserMethod;
  protected Method _newHandMethod;
  protected Method _trackedHandMethod;
  protected Method _lostHandMethod;
  protected Method _newGestureMethod;
  protected Method _inProgressGestureMethod;
  protected Method _abortedGestureMethod;
  protected Method _completedGestureMethod;
  protected Method _startSessionMethod;
  protected Method _endSessionMethod;
  protected Method _focusSessionMethod;
  protected String _filename;
  protected PApplet _parent;
  protected PImage _depthImage;
  protected int[] _depthRaw;
  protected PVector[] _depthMapRealWorld;
  protected float[] _depthMapRealWorldXn;
  protected PImage _rgbImage;
  protected PImage _irImage;
  protected PImage _sceneImage;
  protected int[] _sceneRaw;
  protected PImage _userImage;
  protected int[] _userRaw;
  protected long _depthMapTimeStamp;
  protected long _depthImageTimeStamp;
  protected long _depthRealWorldTimeStamp;
  protected long _rgbTimeStamp;
  protected long _irImageTimeStamp;
  protected long _userMapTimeStamp;
  protected long _userImageTimeStamp;
  
  static
  {
    String str1 = System.getProperty("os.name").toLowerCase();
    String str2 = "SimpleOpenNI";
    String str3 = System.getProperty("os.arch").toLowerCase();
    if (str1.indexOf("win") >= 0)
    {
      if (str3.indexOf("86") >= 0)
      {
        str2 = str2 + "32.dll";
        nativLibPath = getLibraryPathWin() +  workingDir + "\\lib\\";
        nativDepLibPath = nativLibPath + "win32/";
      }
      else if (str3.indexOf("64") >= 0)
      {
        str2 = str2 + "64.dll";
        nativLibPath = getLibraryPathWin() +  workingDir + "\\lib\\";
        nativDepLibPath = nativLibPath + "win64/";
      }
      System.load(nativDepLibPath + "OpenNI2.dll");
      System.load(nativDepLibPath + "NiTE2.dll");
    }
    else if ((str1.indexOf("nix") >= 0) || (str1.indexOf("linux") >= 0))
    {
      nativLibPath = "/SimpleOpenNI/library/linux";
      if (str3.indexOf("86") >= 0)
      {
        str2 = str2 + "32";
      }
      else if (str3.indexOf("64") >= 0)
      {
        str2 = "lib" + str2 + "64.so";
        nativLibPath = getLibraryPathLinux() + "/SimpleOpenNI/library/";
        nativDepLibPath = nativLibPath + "linux64/";
      }
    }
    else if (str1.indexOf("mac") >= 0)
    {
      str2 = "lib" + str2 + ".jnilib";
      nativLibPath = getLibraryPathLinux() + "/SimpleOpenNI/library/";
      nativDepLibPath = nativLibPath + "osx/";
    }
    try
    {
      System.load(nativLibPath + str2);
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      System.out.println("Can't load SimpleOpenNI library (" + str2 + ") : " + localUnsatisfiedLinkError);
      System.out.println("Verify if you installed SimpleOpenNI correctly.\nhttp://code.google.com/p/simple-openni/wiki/Installation");
    }
  }
  
  public static String getLibraryPathLinux()
  {
    URL localURL = SimpleOpenNI.class.getResource("SimpleOpenNI.class");
    if (localURL != null)
    {
      String str = localURL.toString().replace("%20", " ");
      int i = str.indexOf('/');
      
      int j = -1;
      j = str.indexOf("/SimpleOpenNI/library");
      if ((-1 < i) && (-1 < j)) {
        return str.substring(i, j);
      }
      return "";
    }
    return "";
  }
  
  public static String getLibraryPathWin()
  {
    URL localURL = SimpleOpenNI.class.getResource("SimpleOpenNI.class");
    if (localURL != null)
    {
      String str = localURL.toString().replace("%20", " ");
      int i = str.indexOf('/');
      
      int j = -1;
      j = str.indexOf("/SimpleOpenNI/library");
      
      i++;
      if ((-1 < i) && (-1 < j)) {
        return str.substring(i, j);
      }
      return "";
    }
    return "";
  }
  
  public static void start()
  {
    if (_initFlag) {
      return;
    }
    String str = getcwd();
    chdir(new String(nativDepLibPath));
    
    _initFlag = true;
    initContext();
    
    chdir(str);
  }
  
  public static int deviceCount()
  {
    start();
    return ContextWrapper.deviceCount();
  }
  
  public static int deviceNames(StrVector paramStrVector)
  {
    start();
    return ContextWrapper.deviceNames(paramStrVector);
  }
  
  protected float[] _tempVec = new float[3];
  protected static boolean _initFlag = false;
  
  public SimpleOpenNI(PApplet paramPApplet)
  {
    initEnv(paramPApplet, RUN_MODE_SINGLE_THREADED, -1);
  }
  
  public SimpleOpenNI(int paramInt, PApplet paramPApplet)
  {
    initEnv(paramPApplet, RUN_MODE_SINGLE_THREADED, paramInt);
  }
  
  public SimpleOpenNI(int paramInt1, PApplet paramPApplet, int paramInt2)
  {
    initEnv(paramPApplet, paramInt2, paramInt1);
  }
  
  public SimpleOpenNI(PApplet paramPApplet, int paramInt)
  {
    initEnv(paramPApplet, paramInt, -1);
  }
  
  public SimpleOpenNI(PApplet paramPApplet, String paramString, int paramInt)
  {
    String str1 = paramPApplet.dataPath(paramString);
    
    String str2 = getcwd();
    chdir(new String(nativDepLibPath));
    
    this._parent = paramPApplet;
    paramPApplet.registerMethod("dispose", this);
    initVars();
    
    setupCallbackFunc();
    
    init(str1, paramInt);
    
    init(str1, RUN_MODE_DEFAULT);
    if ((nodes() & NODE_DEPTH) > 0) {
      setupDepth();
    }
    if ((nodes() & NODE_IMAGE) > 0) {
      setupRGB();
    }
    if ((nodes() & NODE_IR) > 0) {
      setupIR();
    }
    chdir(str2);
  }
  
  public SimpleOpenNI(PApplet paramPApplet, String paramString)
  {
    String str1 = paramPApplet.dataPath(paramString);
    
    String str2 = getcwd();
    chdir(new String(nativDepLibPath));
    
    this._parent = paramPApplet;
    paramPApplet.registerMethod("dispose", this);
    initVars();
    
    setupCallbackFunc();
    
    init(str1, RUN_MODE_DEFAULT);
    if ((nodes() & NODE_DEPTH) > 0) {
      setupDepth();
    }
    if ((nodes() & NODE_IMAGE) > 0) {
      setupRGB();
    }
    if ((nodes() & NODE_IR) > 0) {
      setupIR();
    }
    chdir(str2);
  }
  
  protected void initEnv(PApplet paramPApplet, int paramInt1, int paramInt2)
  {
    String str = getcwd();
    chdir(new String(nativDepLibPath));
    
    this._parent = paramPApplet;
    paramPApplet.registerMethod("dispose", this);
    initVars();
    
    setupCallbackFunc();
    if (paramInt2 < 0) {
      init(paramInt1);
    } else {
      init(paramInt2, paramInt1);
    }
    chdir(str);
  }
  
  protected void initVars()
  {
    this._depthMapTimeStamp = -1L;
    this._depthImageTimeStamp = -1L;
    this._depthRealWorldTimeStamp = -1L;
    
    this._rgbTimeStamp = -1L;
    
    this._irImageTimeStamp = -1L;
    
    this._userMapTimeStamp = -1L;
    this._userImageTimeStamp = -1L;
  }
  
  protected void setupCallbackFunc()
  {
    this._userCbObject = this._parent;
    this._handCbObject = this._parent;
    this._gestureCbObject = this._parent;
    
    this._calibrationCbObject = this._parent;
    this._poseCbObject = this._parent;
    this._sessionCbObject = this._parent;
    
    this._newUserMethod = null;
    this._lostUserMethod = null;
    this._outOfSceneUserMethod = null;
    this._visibleUserMethod = null;
    
    this._newHandMethod = null;
    this._trackedHandMethod = null;
    this._lostHandMethod = null;
    
    this._newGestureMethod = null;
    this._inProgressGestureMethod = null;
    this._abortedGestureMethod = null;
    this._completedGestureMethod = null;
    
    setupUserCB(this._parent);
    
    setupHandCB(this._parent);
  }
  
  protected Method getMethodRef(String paramString, Class[] paramArrayOfClass)
  {
    Method localMethod = null;
    try
    {
      localMethod = this._parent.getClass().getMethod(paramString, paramArrayOfClass);
    }
    catch (Exception localException) {}
    return localMethod;
  }
  
  public static Method getMethodRef(Object paramObject, String paramString, Class[] paramArrayOfClass)
  {
    Method localMethod = null;
    try
    {
      localMethod = paramObject.getClass().getMethod(paramString, paramArrayOfClass);
    }
    catch (Exception localException) {}
    return localMethod;
  }
  
  public void dispose()
  {
    close();
  }
  
  @Override
public void finalize()
  {
    close();
  }
  
  private void setupDepth()
  {
    this._depthImage = new PImage(depthWidth(), depthHeight(), 1);
    this._depthRaw = new int[depthMapSize()];
    this._depthMapRealWorld = new PVector[depthMapSize()];
    this._depthMapRealWorldXn = new float[depthMapSize() * 3];
    for (int i = 0; i < depthMapSize(); i++) {
      this._depthMapRealWorld[i] = new PVector();
    }
  }
  
  @Override
public boolean enableDepth()
  {
    if (super.enableDepth())
    {
      setupDepth();
      return true;
    }
    return false;
  }
  
  public PImage depthImage()
  {
    updateDepthImage();
    return this._depthImage;
  }
  
  public int[] depthMap()
  {
    updateDepthRaw();
    return this._depthRaw;
  }
  
  public PVector[] depthMapRealWorld()
  {
    updateDepthRealWorld();
    return this._depthMapRealWorld;
  }
  
  private void setupRGB()
  {
    this._rgbImage = new PImage(rgbWidth(), rgbHeight(), 1);
  }
  
  @Override
public boolean enableRGB()
  {
    if (super.enableRGB())
    {
      setupRGB();
      return true;
    }
    return false;
  }
  
  @Override
public boolean enableRGB(int paramInt1, int paramInt2, int paramInt3)
  {
    if (super.enableRGB(paramInt1, paramInt2, paramInt3))
    {
      setupRGB();
      return true;
    }
    return false;
  }
  
  public PImage rgbImage()
  {
    updateImage();
    return this._rgbImage;
  }
  
  private void setupIR()
  {
    this._irImage = new PImage(irWidth(), irHeight(), 1);
  }
  
  @Override
public boolean enableIR()
  {
    if (super.enableIR())
    {
      setupIR();
      return true;
    }
    return false;
  }
  
  @Override
public boolean enableIR(int paramInt1, int paramInt2, int paramInt3)
  {
    if (super.enableIR(paramInt1, paramInt2, paramInt3))
    {
      setupIR();
      return true;
    }
    return false;
  }
  
  public PImage irImage()
  {
    updateIrImage();
    return this._irImage;
  }
  
  private void setupUserCB(Object paramObject)
  {
    this._newUserMethod = getMethodRef(paramObject, "onNewUser", new Class[] { SimpleOpenNI.class, Integer.TYPE });
    this._lostUserMethod = getMethodRef(paramObject, "onLostUser", new Class[] { SimpleOpenNI.class, Integer.TYPE });
    this._outOfSceneUserMethod = getMethodRef(paramObject, "onOutOfSceneUser", new Class[] { SimpleOpenNI.class, Integer.TYPE });
    this._visibleUserMethod = getMethodRef(paramObject, "onVisibleUser", new Class[] { SimpleOpenNI.class, Integer.TYPE });
  }
  
  private void setupUser()
  {
    this._userRaw = new int[userWidth() * userHeight()];
    this._userImage = new PImage(userWidth(), userHeight(), 1);
  }
  
  @Override
public boolean enableUser()
  {
    return enableUser(this._parent);
  }
  
  public boolean enableUser(Object paramObject)
  {
    String str = getcwd();
    chdir(new String(nativDepLibPath));
    
    boolean bool = super.enableUser();
    
    chdir(str);
    if (bool)
    {
      setupUserCB(paramObject);
      setupUser();
      return true;
    }
    return false;
  }
  
  public PImage userImage()
  {
    updateUserImage();
    return this._userImage;
  }
  
  public int[] userMap()
  {
    updateUserRaw();
    return this._userRaw;
  }
  
  public boolean getCoM(int paramInt, PVector paramPVector)
  {
    float[] arrayOfFloat = new float[3];
    
    boolean bool = super.getCoM(paramInt, arrayOfFloat);
    paramPVector.set(arrayOfFloat);
    
    return bool;
  }
  
  public boolean getBoundingBox(int paramInt, PVector paramPVector1, PVector paramPVector2)
  {
    float[] arrayOfFloat = new float[6];
    
    boolean bool = super.getBoundingBox(paramInt, arrayOfFloat);
    paramPVector1.set(arrayOfFloat[0], arrayOfFloat[1], arrayOfFloat[2]);
    paramPVector2.set(arrayOfFloat[3], arrayOfFloat[4], arrayOfFloat[5]);
    
    return bool;
  }
  
  public int[] getUsers()
  {
    IntVector localIntVector = new IntVector();
    getUsers(localIntVector);
    
    int[] arrayOfInt = new int[(int)localIntVector.size()];
    for (int i = 0; i < localIntVector.size(); i++) {
      arrayOfInt[i] = localIntVector.get(i);
    }
    return arrayOfInt;
  }
  
  private void setupHandCB(Object paramObject)
  {
    this._newHandMethod = getMethodRef(paramObject, "onNewHand", new Class[] { SimpleOpenNI.class, Integer.TYPE, PVector.class });
    this._trackedHandMethod = getMethodRef(paramObject, "onTrackedHand", new Class[] { SimpleOpenNI.class, Integer.TYPE, PVector.class });
    this._lostHandMethod = getMethodRef(paramObject, "onLostHand", new Class[] { SimpleOpenNI.class, Integer.TYPE });
    
    this._newGestureMethod = getMethodRef(paramObject, "onNewGesture", new Class[] { SimpleOpenNI.class, Integer.TYPE });
    this._inProgressGestureMethod = getMethodRef(paramObject, "onProgressGesture", new Class[] { SimpleOpenNI.class, Integer.TYPE });
    this._abortedGestureMethod = getMethodRef(paramObject, "onAbortedGesture", new Class[] { SimpleOpenNI.class, Integer.TYPE });
    this._completedGestureMethod = getMethodRef(paramObject, "onCompletedGesture", new Class[] { SimpleOpenNI.class, Integer.TYPE, PVector.class });
  }
  
  @Override
public boolean enableHand()
  {
    return enableHand(this._parent);
  }
  
  public boolean enableHand(Object paramObject)
  {
    this._handCbObject = paramObject;
    if (super.enableHand())
    {
      setupHandCB(this._handCbObject);
      return true;
    }
    return false;
  }
  
  public int startTrackingHand(PVector paramPVector)
  {
    return super.startTrackingHand(paramPVector.array());
  }
  
  @Override
public boolean enableRecorder(String paramString)
  {
    String str = this._parent.dataPath(paramString);
    PApplet.createPath(str);
    if (super.enableRecorder(str)) {
      return true;
    }
    return false;
  }
  
  protected void updateDepthRaw()
  {
    if ((nodes() & NODE_DEPTH) == 0) {
      return;
    }
    if (this._depthMapTimeStamp == updateTimeStamp()) {
      return;
    }
    depthMap(this._depthRaw);
    this._depthMapTimeStamp = updateTimeStamp();
  }
  
  protected void updateDepthImage()
  {
    if ((nodes() & NODE_DEPTH) == 0) {
      return;
    }
    if (this._depthImageTimeStamp == updateTimeStamp()) {
      return;
    }
    this._depthImage.loadPixels();
    depthImage(this._depthImage.pixels);
    this._depthImage.updatePixels();
    this._depthImageTimeStamp = updateTimeStamp();
  }
  
  protected void updateDepthRealWorld()
  {
    if ((nodes() & NODE_DEPTH) == 0) {
      return;
    }
    if (this._depthRealWorldTimeStamp == updateTimeStamp()) {
      return;
    }
    depthMapRealWorld(this._depthMapRealWorldXn);
    int i = 0;
    for (int j = 0; j < this._depthMapRealWorld.length; j++) {
      this._depthMapRealWorld[j].set(this._depthMapRealWorldXn[(i++)], this._depthMapRealWorldXn[(i++)], this._depthMapRealWorldXn[(i++)]);
    }
    this._depthRealWorldTimeStamp = updateTimeStamp();
  }
  
  protected void updateImage()
  {
    if ((nodes() & NODE_IMAGE) == 0) {
      return;
    }
    if (this._rgbTimeStamp == updateTimeStamp()) {
      return;
    }
    this._rgbImage.loadPixels();
    rgbImage(this._rgbImage.pixels);
    this._rgbImage.updatePixels();
    
    this._rgbTimeStamp = updateTimeStamp();
  }
  
  protected void updateIrImage()
  {
    if ((nodes() & NODE_IR) == 0) {
      return;
    }
    if (this._irImageTimeStamp == updateTimeStamp()) {
      return;
    }
    this._irImage.loadPixels();
    irImage(this._irImage.pixels);
    this._irImage.updatePixels();
    
    this._irImageTimeStamp = updateTimeStamp();
  }
  
  protected void updateUserRaw()
  {
    if ((nodes() & NODE_USER) == 0) {
      return;
    }
    if (this._userImageTimeStamp == updateTimeStamp()) {
      return;
    }
    userMap(this._userRaw);
    
    this._userImageTimeStamp = updateTimeStamp();
  }
  
  protected void updateUserImage()
  {
    if ((nodes() & NODE_USER) == 0) {
      return;
    }
    if (this._userImageTimeStamp == updateTimeStamp()) {
      return;
    }
    this._userImage.loadPixels();
    userImage(this._userImage.pixels);
    this._userImage.updatePixels();
    this._userImageTimeStamp = updateTimeStamp();
  }
  
  @Override
public void update()
  {
    super.update();
  }
  
  public void drawLimb(int paramInt1, int paramInt2, int paramInt3)
  {
    PVector localPVector1 = new PVector();
    PVector localPVector2 = new PVector();
    
    getJointPositionSkeleton(paramInt1, paramInt2, localPVector1);
    getJointPositionSkeleton(paramInt1, paramInt3, localPVector2);
    
    PVector localPVector3 = new PVector();
    PVector localPVector4 = new PVector();
    
    convertRealWorldToProjective(localPVector1, localPVector3);
    convertRealWorldToProjective(localPVector2, localPVector4);
    
    this._parent.line(localPVector3.x, localPVector3.y, localPVector4.x, localPVector4.y);
  }
  
  public float getJointPositionSkeleton(int paramInt1, int paramInt2, PVector paramPVector)
  {
    float f = getJointPositionSkeleton(paramInt1, paramInt2, this._tempVec);
    paramPVector.set(this._tempVec);
    return f;
  }
  
  public float getJointOrientationSkeleton(int paramInt1, int paramInt2, PMatrix3D paramPMatrix3D)
  {
    float[] arrayOfFloat = new float[9];
    
    float f = getJointOrientationSkeleton(paramInt1, paramInt2, arrayOfFloat);
    
    paramPMatrix3D.set(arrayOfFloat[0], arrayOfFloat[1], arrayOfFloat[2], 0.0F, arrayOfFloat[3], arrayOfFloat[4], arrayOfFloat[5], 0.0F, arrayOfFloat[6], arrayOfFloat[7], arrayOfFloat[8], 0.0F, 0.0F, 0.0F, 0.0F, 1.0F);
    
    return f;
  }
  
  public void convertRealWorldToProjective(PVector paramPVector1, PVector paramPVector2)
  {
    convertRealWorldToProjective(paramPVector1.array(), this._tempVec);
    paramPVector2.set(this._tempVec);
  }
  
  public void convertProjectiveToRealWorld(PVector paramPVector1, PVector paramPVector2)
  {
    convertProjectiveToRealWorld(paramPVector1.array(), this._tempVec);
    paramPVector2.set(this._tempVec);
  }
  
  public void getUserCoordsysTransMat(PMatrix3D paramPMatrix3D)
  {
    if (!hasUserCoordsys()) {
      return;
    }
    float[] arrayOfFloat = new float[16];
    getUserCoordsysTransMat(arrayOfFloat);
    
    paramPMatrix3D.set(arrayOfFloat[0], arrayOfFloat[1], arrayOfFloat[2], arrayOfFloat[3], arrayOfFloat[4], arrayOfFloat[5], arrayOfFloat[6], arrayOfFloat[7], arrayOfFloat[8], arrayOfFloat[9], arrayOfFloat[10], arrayOfFloat[11], arrayOfFloat[12], arrayOfFloat[13], arrayOfFloat[14], arrayOfFloat[15]);
  }
  
  public void calcUserCoordsys(PVector paramPVector)
  {
    if (!hasUserCoordsys()) {
      return;
    }
    float[] arrayOfFloat = new float[3];
    calcUserCoordsys(arrayOfFloat);
    paramPVector.set(arrayOfFloat[0], arrayOfFloat[1], arrayOfFloat[2]);
  }
  
  public void calcUserCoordsys(PMatrix3D paramPMatrix3D)
  {
    if (!hasUserCoordsys()) {
      return;
    }
    float[] arrayOfFloat = new float[9];
    arrayOfFloat[0] = paramPMatrix3D.m00;
    arrayOfFloat[1] = paramPMatrix3D.m01;
    arrayOfFloat[2] = paramPMatrix3D.m02;
    
    arrayOfFloat[3] = paramPMatrix3D.m10;
    arrayOfFloat[4] = paramPMatrix3D.m11;
    arrayOfFloat[5] = paramPMatrix3D.m12;
    
    arrayOfFloat[6] = paramPMatrix3D.m20;
    arrayOfFloat[7] = paramPMatrix3D.m21;
    arrayOfFloat[8] = paramPMatrix3D.m22;
    
    calcUserCoordsys(arrayOfFloat);
    
    paramPMatrix3D.set(arrayOfFloat[0], arrayOfFloat[1], arrayOfFloat[2], 0.0F, arrayOfFloat[3], arrayOfFloat[4], arrayOfFloat[5], 0.0F, arrayOfFloat[6], arrayOfFloat[7], arrayOfFloat[8], 0.0F, 0.0F, 0.0F, 0.0F, 1.0F);
  }
  
  public void calcUserCoordsysBack(PVector paramPVector)
  {
    if (!hasUserCoordsys()) {
      return;
    }
    float[] arrayOfFloat = new float[3];
    calcUserCoordsysBack(arrayOfFloat);
    paramPVector.set(arrayOfFloat[0], arrayOfFloat[1], arrayOfFloat[2]);
  }
  
  public void calcUserCoordsysBack(PMatrix3D paramPMatrix3D)
  {
    if (!hasUserCoordsys()) {
      return;
    }
    float[] arrayOfFloat = new float[9];
    arrayOfFloat[0] = paramPMatrix3D.m00;
    arrayOfFloat[1] = paramPMatrix3D.m01;
    arrayOfFloat[2] = paramPMatrix3D.m02;
    
    arrayOfFloat[3] = paramPMatrix3D.m10;
    arrayOfFloat[4] = paramPMatrix3D.m11;
    arrayOfFloat[5] = paramPMatrix3D.m12;
    
    arrayOfFloat[6] = paramPMatrix3D.m20;
    arrayOfFloat[7] = paramPMatrix3D.m21;
    arrayOfFloat[8] = paramPMatrix3D.m22;
    
    calcUserCoordsysBack(arrayOfFloat);
    
    paramPMatrix3D.set(arrayOfFloat[0], arrayOfFloat[1], arrayOfFloat[2], 0.0F, arrayOfFloat[3], arrayOfFloat[4], arrayOfFloat[5], 0.0F, arrayOfFloat[6], arrayOfFloat[7], arrayOfFloat[8], 0.0F, 0.0F, 0.0F, 0.0F, 1.0F);
  }
  
  public void getUserCoordsys(PMatrix3D paramPMatrix3D)
  {
    if (!hasUserCoordsys()) {
      return;
    }
    float[] arrayOfFloat = new float[16];
    getUserCoordsys(arrayOfFloat);
    
    paramPMatrix3D.set(arrayOfFloat[0], arrayOfFloat[1], arrayOfFloat[2], arrayOfFloat[3], arrayOfFloat[4], arrayOfFloat[5], arrayOfFloat[6], arrayOfFloat[7], arrayOfFloat[8], arrayOfFloat[9], arrayOfFloat[10], arrayOfFloat[11], arrayOfFloat[12], arrayOfFloat[13], arrayOfFloat[14], arrayOfFloat[15]);
  }
  
  public void getUserCoordsysBack(PMatrix3D paramPMatrix3D)
  {
    if (!hasUserCoordsys()) {
      return;
    }
    float[] arrayOfFloat = new float[16];
    getUserCoordsysBack(arrayOfFloat);
    
    paramPMatrix3D.set(arrayOfFloat[0], arrayOfFloat[1], arrayOfFloat[2], arrayOfFloat[3], arrayOfFloat[4], arrayOfFloat[5], arrayOfFloat[6], arrayOfFloat[7], arrayOfFloat[8], arrayOfFloat[9], arrayOfFloat[10], arrayOfFloat[11], arrayOfFloat[12], arrayOfFloat[13], arrayOfFloat[14], arrayOfFloat[15]);
  }
  
  public void drawCamFrustum()
  {
    this._parent.g.pushStyle();
    this._parent.g.pushMatrix();
    if (hasUserCoordsys())
    {
      PMatrix3D localPMatrix3D = new PMatrix3D();
      getUserCoordsys(localPMatrix3D);
      this._parent.g.applyMatrix(localPMatrix3D);
    }
    this._parent.stroke(200.0F, 200.0F, 0.0F);
    this._parent.noFill();
    this._parent.g.beginShape();
    this._parent.g.vertex(135.0F, 20.0F, 0.0F);
    this._parent.g.vertex(-135.0F, 20.0F, 0.0F);
    this._parent.g.vertex(-135.0F, -20.0F, 0.0F);
    this._parent.g.vertex(135.0F, -20.0F, 0.0F);
    this._parent.g.endShape(2);
    
    this._parent.g.beginShape();
    this._parent.g.vertex(110.0F, 20.0F, -50.0F);
    this._parent.g.vertex(-110.0F, 20.0F, -50.0F);
    this._parent.g.vertex(-110.0F, -20.0F, -50.0F);
    this._parent.g.vertex(110.0F, -20.0F, -50.0F);
    this._parent.g.endShape(2);
    
    this._parent.g.beginShape(5);
    this._parent.g.vertex(135.0F, 20.0F, 0.0F);
    this._parent.g.vertex(110.0F, 20.0F, -50.0F);
    
    this._parent.g.vertex(-135.0F, 20.0F, 0.0F);
    this._parent.g.vertex(-110.0F, 20.0F, -50.0F);
    
    this._parent.g.vertex(-135.0F, -20.0F, 0.0F);
    this._parent.g.vertex(-110.0F, -20.0F, -50.0F);
    
    this._parent.g.vertex(135.0F, -20.0F, 0.0F);
    this._parent.g.vertex(110.0F, -20.0F, -50.0F);
    this._parent.g.endShape();
    
    this._parent.stroke(200.0F, 200.0F, 0.0F, 50.0F);
    this._parent.g.line(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1000.0F);
    
    float f1 = 10000.0F;
    
    float f2 = f1 * PApplet.tan(hFieldOfView() * 0.5F);
    float f3 = f1 * PApplet.tan(vFieldOfView() * 0.5F);
    
    this._parent.stroke(200.0F, 200.0F, 0.0F, 100.0F);
    this._parent.g.line(0.0F, 0.0F, 0.0F, f2, f3, f1);
    
    this._parent.g.line(0.0F, 0.0F, 0.0F, -f2, f3, f1);
    
    this._parent.g.line(0.0F, 0.0F, 0.0F, f2, -f3, f1);
    
    this._parent.g.line(0.0F, 0.0F, 0.0F, -f2, -f3, f1);
    
    this._parent.g.beginShape();
    this._parent.g.vertex(f2, f3, f1);
    this._parent.g.vertex(-f2, f3, f1);
    this._parent.g.vertex(-f2, -f3, f1);
    this._parent.g.vertex(f2, -f3, f1);
    this._parent.g.endShape(2);
    
    this._parent.g.popMatrix();
    this._parent.g.popStyle();
  }
  
  public static boolean rayTriangleIntersection(PVector paramPVector1, PVector paramPVector2, PVector paramPVector3, PVector paramPVector4, PVector paramPVector5, PVector paramPVector6)
  {
    float[] arrayOfFloat = new float[3];
    if (rayTriangleIntersection(paramPVector1.array(), paramPVector2.array(), paramPVector3.array(), paramPVector4.array(), paramPVector5.array(), arrayOfFloat))
    {
      paramPVector6.set(arrayOfFloat);
      return true;
    }
    return false;
  }
  
  public static int raySphereIntersection(PVector paramPVector1, PVector paramPVector2, PVector paramPVector3, float paramFloat, PVector paramPVector4, PVector paramPVector5)
  {
    float[] arrayOfFloat1 = new float[3];
    float[] arrayOfFloat2 = new float[3];
    
    int i = raySphereIntersection(paramPVector1.array(), paramPVector2.array(), paramPVector3
      .array(), paramFloat, arrayOfFloat1, arrayOfFloat2);
    if (i > 0)
    {
      paramPVector4.set(arrayOfFloat1);
      if (i > 1) {
        paramPVector5.set(arrayOfFloat2);
      }
    }
    return i;
  }
  
  @Override
protected void onNewUserCb(int paramInt)
  {
    try
    {
      this._newUserMethod.invoke(this._userCbObject, new Object[] { this, Integer.valueOf(paramInt) });
    }
    catch (Exception localException) {}
  }
  
  @Override
protected void onLostUserCb(int paramInt)
  {
    try
    {
      this._lostUserMethod.invoke(this._userCbObject, new Object[] { this, Integer.valueOf(paramInt) });
    }
    catch (Exception localException) {}
  }
  
  @Override
protected void onOutOfSceneUserCb(int paramInt)
  {
    try
    {
      this._outOfSceneUserMethod.invoke(this._userCbObject, new Object[] { this, Integer.valueOf(paramInt) });
    }
    catch (Exception localException) {}
  }
  
  @Override
protected void onVisibleUserCb(int paramInt)
  {
    try
    {
      this._visibleUserMethod.invoke(this._userCbObject, new Object[] { this, Integer.valueOf(paramInt) });
    }
    catch (Exception localException) {}
  }
  
  @Override
protected void onNewHandCb(int paramInt, Vec3f paramVec3f)
  {
    try
    {
      this._newHandMethod.invoke(this._handCbObject, new Object[] { this, Integer.valueOf(paramInt), new PVector(paramVec3f.x(), paramVec3f.y(), paramVec3f.z()) });
    }
    catch (Exception localException) {}
  }
  
  @Override
protected void onLostHandCb(int paramInt)
  {
    try
    {
      this._lostHandMethod.invoke(this._handCbObject, new Object[] { this, Integer.valueOf(paramInt) });
    }
    catch (Exception localException) {}
  }
  
  @Override
protected void onTrackedHandCb(int paramInt, Vec3f paramVec3f)
  {
    try
    {
      this._trackedHandMethod.invoke(this._handCbObject, new Object[] { this, Integer.valueOf(paramInt), new PVector(paramVec3f.x(), paramVec3f.y(), paramVec3f.z()) });
    }
    catch (Exception localException) {}
  }
  
  @Override
protected void onNewGestureCb(int paramInt)
  {
    try
    {
      this._newGestureMethod.invoke(this._handCbObject, new Object[] { this, Integer.valueOf(paramInt) });
    }
    catch (Exception localException) {}
  }
  
  @Override
protected void onInProgressGestureCb(int paramInt)
  {
    try
    {
      this._inProgressGestureMethod.invoke(this._handCbObject, new Object[] { this, Integer.valueOf(paramInt) });
    }
    catch (Exception localException) {}
  }
  
  @Override
protected void onAbortedGestureCb(int paramInt)
  {
    System.out.println("onAbortedGestureCb");
    try
    {
      this._abortedGestureMethod.invoke(this._handCbObject, new Object[] { this, Integer.valueOf(paramInt) });
    }
    catch (Exception localException) {}
  }
  
  @Override
protected void onCompletedGestureCb(int paramInt, Vec3f paramVec3f)
  {
    try
    {
      this._completedGestureMethod.invoke(this._handCbObject, new Object[] { this, Integer.valueOf(paramInt), new PVector(paramVec3f.x(), paramVec3f.y(), paramVec3f.z()) });
    }
    catch (Exception localException) {}
  }
}
