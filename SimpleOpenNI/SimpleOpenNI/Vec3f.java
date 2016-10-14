package SimpleOpenNI;

public class Vec3f
{
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;
  
  protected Vec3f(long paramLong, boolean paramBoolean)
  {
    this.swigCMemOwn = paramBoolean;
    this.swigCPtr = paramLong;
  }
  
  protected static long getCPtr(Vec3f paramVec3f)
  {
    return paramVec3f == null ? 0L : paramVec3f.swigCPtr;
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
        SimpleOpenNIJNI.delete_Vec3f(this.swigCPtr);
      }
      this.swigCPtr = 0L;
    }
  }
  
  public Vec3f(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this(SimpleOpenNIJNI.new_Vec3f__SWIG_0(paramFloat1, paramFloat2, paramFloat3), true);
  }
  
  public Vec3f(Vec3f paramVec3f)
  {
    this(SimpleOpenNIJNI.new_Vec3f__SWIG_1(getCPtr(paramVec3f), paramVec3f), true);
  }
  
  public float x()
  {
    return SimpleOpenNIJNI.Vec3f_x(this.swigCPtr, this);
  }
  
  public float y()
  {
    return SimpleOpenNIJNI.Vec3f_y(this.swigCPtr, this);
  }
  
  public float z()
  {
    return SimpleOpenNIJNI.Vec3f_z(this.swigCPtr, this);
  }
}
