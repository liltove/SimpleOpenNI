package SimpleOpenNI;

public class StrVector
{
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;
  
  protected StrVector(long paramLong, boolean paramBoolean)
  {
    this.swigCMemOwn = paramBoolean;
    this.swigCPtr = paramLong;
  }
  
  protected static long getCPtr(StrVector paramStrVector)
  {
    return paramStrVector == null ? 0L : paramStrVector.swigCPtr;
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
        SimpleOpenNIJNI.delete_StrVector(this.swigCPtr);
      }
      this.swigCPtr = 0L;
    }
  }
  
  public StrVector()
  {
    this(SimpleOpenNIJNI.new_StrVector__SWIG_0(), true);
  }
  
  public StrVector(long paramLong)
  {
    this(SimpleOpenNIJNI.new_StrVector__SWIG_1(paramLong), true);
  }
  
  public long size()
  {
    return SimpleOpenNIJNI.StrVector_size(this.swigCPtr, this);
  }
  
  public long capacity()
  {
    return SimpleOpenNIJNI.StrVector_capacity(this.swigCPtr, this);
  }
  
  public void reserve(long paramLong)
  {
    SimpleOpenNIJNI.StrVector_reserve(this.swigCPtr, this, paramLong);
  }
  
  public boolean isEmpty()
  {
    return SimpleOpenNIJNI.StrVector_isEmpty(this.swigCPtr, this);
  }
  
  public void clear()
  {
    SimpleOpenNIJNI.StrVector_clear(this.swigCPtr, this);
  }
  
  public void add(String paramString)
  {
    SimpleOpenNIJNI.StrVector_add(this.swigCPtr, this, paramString);
  }
  
  public String get(int paramInt)
  {
    return SimpleOpenNIJNI.StrVector_get(this.swigCPtr, this, paramInt);
  }
  
  public void set(int paramInt, String paramString)
  {
    SimpleOpenNIJNI.StrVector_set(this.swigCPtr, this, paramInt, paramString);
  }
}
