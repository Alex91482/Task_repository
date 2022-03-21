using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class MouseLook : MonoBehaviour
{
	//переменные скорости изменения позиции
	public float sensitivityHor = 5.0f;
	public float sensitivityVert = 5.0f;
	//минимальный и максимальный углы поворота в вертикальной плоскости
	public float minVert = -45.0f;
	public float maxVert = 30.0f;
	//переменная для угла поворота по вертикали
	private float _rotationX = 0;

	public enum RotationAxes
	{
		MouseXAndY = 0,
		MouseX = 1,
		MouseY = 2
	}
	public RotationAxes axes = RotationAxes.MouseXAndY;

    void Start(){
    }

    void Update()
    {
		if(Input.GetMouseButton(1)){ //если зажать правую кнопку мыши ожно вращать камеру
			if(axes == RotationAxes.MouseX){
				//поворот в горизонтальной плоскости
				transform.Rotate(0, Input.GetAxis("Mouse X") * sensitivityHor, 0);
			}
			else if(axes == RotationAxes.MouseY){
				//поворот в вертикальной плоскости
				_rotationX -= Input.GetAxis("Mouse Y") * sensitivityVert;
				_rotationX = Mathf.Clamp(_rotationX, minVert, maxVert); //фиксируем угол поворота по вертикали в диапазоне
				float rotationY = transform.localEulerAngles.y; //сохраняем одинаковый угол поворота вокруг оси Y
				transform.localEulerAngles = new Vector3(_rotationX, rotationY, 0); //создаем новый вектор из значений поворота
			}
			else{
				//комбинированный поворот
				_rotationX -= Input.GetAxis("Mouse Y") * sensitivityVert;
				_rotationX = Mathf.Clamp(_rotationX, minVert, maxVert);
				
				float delta = Input.GetAxis("Mouse X") * sensitivityHor;
				float rotationY = transform.localEulerAngles.y + delta;
				
				transform.localEulerAngles = new Vector3(_rotationX, rotationY, 0);
			}
		}
    }
	
}
