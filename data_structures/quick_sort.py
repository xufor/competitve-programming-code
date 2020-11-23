def partition(arr, low, high):
    j = low
    for i in range(low, high):
        if arr[i] < arr[high]:
            arr[i], arr[j] = arr[j], arr[i]
            j += 1
    arr[high], arr[j] = arr[j], arr[high]
    return j

def quick_sort(arr, low, high):
    if low < high:
        p = partition(arr, low, high)
        quick_sort(arr, low, p-1)
        quick_sort(arr, p+1, high)


arr = [7,12,1,4,5]
quick_sort(arr, 0, len(arr)-1)
print(arr)