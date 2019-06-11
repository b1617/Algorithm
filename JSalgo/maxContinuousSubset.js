/*
Find maximun continuous subset

input : array
input : size of maximun subset

example : 
array : [12,4,3,5,8,7];
size of subset : 3
result = 20 -> [5,8,7]
*/

let array = [12, 4, 3, 5, 8, 7];
let size = 3;

console.log(findMaximunSubset(array, size));
console.log(findMaxSubset(array, size));


// max = a.length - (size-1);
// brute force : O(max*size)
function findMaximunSubset(array, size) {
    let max = 0;
    for (let i = 0; i <= array.length - size; ++i) {
        let maxSubset = 0;
        for (let j = i; j < i + size; ++j) {
            maxSubset += array[j];
        }
        max = Math.max(max, maxSubset);
    }
    return max;
}
// window sliding :  O(n)
function findMaxSubset(array, size) {
    let totalSubset = 0;
    for (let i = 0; i < size; ++i) {
        totalSubset += array[i];
    }
    let max = totalSubset;
    for (let j = size; j < array.length; ++j) {
        totalSubset += array[j] - array[j - size];
        max = Math.max(max, totalSubset);
    }
    return max;
}
