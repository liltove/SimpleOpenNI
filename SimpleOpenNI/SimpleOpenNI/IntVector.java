package SimpleOpenNI;

public class IntVector
{
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;
  
  protected IntVector(long paramLong, boolean paramBoolean)
  {
    this.swigCMemOwn = paramBoolean;
    this.swigCPtr = paramLong;
  }
  
  protected static long getCPtr(IntVector paramIntVector)
  {
    return paramIntVector == null ? 0L : paramIntVector.swigCPtr;
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
        SimpleOpenNIJNI.delete_IntVector(this.swigCPtr);
      }
      this.swigCPtr = 0L;
    }
  }
  
  public IntVector()
  {
    this(SimpleOpenNIJNI.new_IntVector__SWIG_0(), true);
  }
  
  public IntVector(long paramLong)
  {
    this(SimpleOpenNIJNI.new_IntVector__SWIG_1(paramLong), true);
  }
  
  public long size()
  {
    return SimpleOpenNIJNI.IntVector_size(this.swigCPtr, this);
  }
  
  public long capacity()
  {
    return SimpleOpenNIJNI.IntVector_capacity(this.swigCPtr, this);
  }
  
  public void reserve(long paramLong)
  {
    SimpleOpenNIJNI.IntVector_reserve(this.swigCPtr, this, paramLong);
  }
  
  public boolean isEmpty()
  {
    return SimpleOpenNIJNI.IntVector_isEmpty(this.swigCPtr, this);
  }
  
  public void clear()
  {
    SimpleOpenNIJNI.IntVector_clear(this.swigCPtr, this);
  }
  
  public void add(int paramInt)
  {
    SimpleOpenNIJNI.IntVector_add(this.swigCPtr, this, paramInt);
  }
  
  public int get(int paramInt)
  {
    return SimpleOpenNIJNI.IntVector_get(this.swigCPtr, this, paramInt);
  }
  
  public void set(int paramInt1, int paramInt2)
  {
    SimpleOpenNIJNI.IntVector_set(this.swigCPtr, this, paramInt1, paramInt2);
  }
}
