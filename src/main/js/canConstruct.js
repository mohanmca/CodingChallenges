
const canConstruct = (target, words) => {
    if(target === '') return true;
    for(let word of words) {
        if(target.startsWith(word)) {
            //let suffix = target.slice(word.length)
            let suffix = target.substring(word.length)
            if(canConstruct(suffix, words)) {
                return true;
            }
        }
    }
    return false;
}

console.log(canConstruct('abcdef', ['ab', 'abc', 'cd', 'def', 'abcd']))
console.log(canConstruct('skateabcdefg', ['ab', 'abc', 'cd', 'def', 'abcd','ska','te','bo']))
console.log(canConstruct('eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef', ['e', 'ee', 'eee', 'eeee', 'eeeee','eeeeee','te','bo']))